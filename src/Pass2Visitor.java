import static wci.intermediate.symtabimpl.SymTabKeyImpl.*;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;

import wci.intermediate.*;
import wci.intermediate.symtabimpl.*;

import static wci.intermediate.symtabimpl.DefinitionImpl.FUNCTION;

public class Pass2Visitor extends ClangBaseVisitor<Integer> 
{
	private SymTabStack symTabStack;
	String programId;
	private ArrayList<SymTabEntry> variableIdList;
	private PrintWriter jFile;
	private int countRelOp;
	private int countEqOp;
	private int countAnd;
	private int countOr;
	private int countNot;
	private int countWhile;
	private int countFor;
	private int countIf;
	private int countLocalVars;
	private boolean insideWhile;
	private boolean insideFor;
	private boolean local;
	private TypeSpec currentRtnType;
	private String inputFileName;
	private boolean error;
	private boolean parsingMain;
    
	public Pass2Visitor(SymTabStack symTabStack, ArrayList<SymTabEntry> variableIdList, PrintWriter jFile, String inputFileName)
	{
		this.symTabStack = symTabStack;
		this.variableIdList = variableIdList;
		this.jFile = jFile;
		countRelOp = 0;
		countEqOp = 0;
		countAnd = 0;
		countOr = 0;
		countNot = 0;
		countWhile = 0;
		countFor = 0;
		countIf = 0;
		this.inputFileName = inputFileName;
		error = false;
		parsingMain = false;
    }
	
	public boolean getError()
	{
		return error;
	}
	
	@Override
	public Integer visitProgram(ClangParser.ProgramContext ctx)
	{	
		programId = inputFileName;
		return visitChildren(ctx);
	}
	
	@Override 
	public Integer visitMain_func(ClangParser.Main_funcContext ctx) 
    {
    	local = true;
    	parsingMain = true;
		symTabStack.push();
		
		// Emit the main program header.
		jFile.println();
		jFile.println(".method public static main([Ljava/lang/String;)V");
    	jFile.println();
    	jFile.println("\tnew java/util/Scanner");
    	jFile.println("\tdup");
    	jFile.println("\tgetstatic java/lang/System/in Ljava/io/InputStream;");
    	jFile.println("\tinvokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V");
    	jFile.println("\tputstatic " + programId + "/_scanner Ljava/util/Scanner;");
    	jFile.println();
    	jFile.println("\tnew RunTimer");
    	jFile.println("\tdup");
    	jFile.println("\tinvokenonvirtual RunTimer/<init>()V");
    	jFile.println("\tputstatic " + programId + "/_runTimer LRunTimer;");
    	jFile.println();
    	jFile.println("\tnew PascalTextIn");
    	jFile.println("\tdup");
    	jFile.println("\tinvokenonvirtual PascalTextIn/<init>()V");
    	jFile.println("\tputstatic " + programId + "/_standardIn LPascalTextIn;");
        
    	// Initialize global array.
    	for (SymTabEntry variableId : variableIdList) {
    		String variableName = variableId.getName();
    		@SuppressWarnings("unchecked")
			ArrayList<Integer> subscripts =
    				(ArrayList<Integer>)variableId.getAttribute(SUBSCRIPTS);
    	
    		// If there is at least one subscript, this variable is an array. 
    		if (subscripts != null) {
				String arrayNotation = "";
				String typeIndicator;
				for (int i = 0; i < subscripts.size(); i++) {
					jFile.println("\tldc\t" + subscripts.get(i));
					arrayNotation += "[";
				}
				
				if (variableId.getTypeSpec() == Predefined.integerType) {
					typeIndicator = "I";
					
				} else if (variableId.getTypeSpec() == Predefined.realType) {
					typeIndicator = "F";
					
				} else if (variableId.getTypeSpec() == Predefined.stringType) {
					typeIndicator = "java/lang/String;";
				} else {
					typeIndicator = "?";
				}
				
    			if (subscripts.size() == 1) {
    				// One-dimensional array.
    				if (variableId.getTypeSpec() == Predefined.integerType) {
    					jFile.println("\tnewarray\tint");
    					
    				} else if (variableId.getTypeSpec() == Predefined.realType) {
    					jFile.println("\tnewarray\tfloat");

    				} else if (variableId.getTypeSpec() == Predefined.stringType) {
    					jFile.println("\tanewarray\tjava/lang/String");
    				}
    			} else {
    				// Multidimensional array.
    				jFile.println("\tmultianewarray\t" + arrayNotation +
    						typeIndicator + "\t" + subscripts.size());
    				
    			}
    			jFile.println("\tputstatic\t" + programId + "/" + variableName + "\t" +
    					arrayNotation + typeIndicator);
    		}
    	}
    	
    	currentRtnType = Predefined.integerType;
    	
    	Integer value = visitChildren(ctx);
    	
    	currentRtnType = null;
        
    	// Emit the main program epilogue.
    	jFile.println();
    	jFile.println("\tgetstatic     " + programId + "/_runTimer LRunTimer;");
    	jFile.println("\tinvokevirtual RunTimer.printElapsedTime()V");
    	jFile.println();
    	jFile.println("\treturn");
    	jFile.println();
    	jFile.println(".limit locals "+ countLocalVars);
    	jFile.println(".limit stack 64");
    	jFile.println(".end method");
        
    	jFile.close();
    	
    	symTabStack.pop();
    	parsingMain = false;
    	local = false;

    	return value;
    }

	@Override
	public Integer visitGlobal_var_decl(ClangParser.Global_var_declContext ctx)
    {
    	// Avoid to process global variable declaration twice.
    	return null;
    }
    
	@Override 
	public Integer visitStmt(ClangParser.StmtContext ctx) 
    { 
        jFile.println("\n; " + ctx.getText());
        return visitChildren(ctx); 
    }
    
	@Override 
	public Integer visitAssign_stmt(ClangParser.Assign_stmtContext ctx)
    {
		int lineNumber = ctx.getStart().getLine();
    	Integer value = null;

    	String variableName = ctx.identifier().ID().toString();
    	SymTabEntry variableId = symTabStack.lookupGlobal(variableName);
    	if (variableId != null) {
    		TypeSpec typeSpec = variableId.getTypeSpec();
    	   	String typeIndicator =
    	   			(typeSpec == Predefined.integerType)	? "I" :
    	      		(typeSpec == Predefined.realType)		? "F" :
            		(typeSpec == Predefined.stringType)	? "Ljava/lang/String;" :
    	       		"?";
    	   	Integer dimension = (Integer)variableId.getAttribute(DIMENSION);
    	    if (dimension != null && dimension > 0) {
    	    	// Global array variable.
    	   		String arrayNotation = "";
    	    	for (int i = 0; i < dimension; i++) {
    	    		arrayNotation += "[";
    	    	}
    	    	jFile.println("\tgetstatic\t" + programId + "/" +  variableName + "\t" +
    	    			arrayNotation + typeIndicator);
    		
            	for (int i = 0 ; i < dimension; i++) {			
          			ParseTree exprTree = ctx.identifier().expr(i);
          			value = visit(exprTree);
            			
          			if (i < dimension-1) {
          				jFile.println("\taaload");
          			}
           		}
    	    		
    		    // Right hand side of assignment statement (expression).
            	ParseTree exprTree = ctx.expr();
    			value = visit(exprTree);
    			
				if (typeSpec == Predefined.integerType) {
					jFile.println("\tiastore");
				} else if (typeSpec == Predefined.realType) {
					jFile.println("\tfastore");
				} else if (typeSpec == Predefined.stringType) {
					jFile.println("\taastore");
				}
    				
    	    } else {
    		   	// Right hand side of assignment statement (expression).
            	ParseTree exprTree = ctx.expr();
    			value = visit(exprTree);
    				
    	    	// Global normal variable.
    	    	jFile.println("\tputstatic\t" + programId +
    	    			"/" + variableName + " " + typeIndicator);
    	    }
    	    // Type Checking.
        	TypeSpec rightType = ctx.expr().typeSpec;
        	TypeSpec leftType = variableId.getTypeSpec();
            
        	boolean integerMode =
        			(rightType == Predefined.integerType) &&
        			(leftType == Predefined.integerType);
        	boolean realMode = 
        			(rightType == Predefined.realType) &&
        			(leftType == Predefined.realType);
        	boolean stringMode = 
        			(rightType == Predefined.stringType) &&
        			(leftType == Predefined.stringType);
        	
        	if (!(integerMode || realMode || stringMode)) {
        		System.out.println("Line " + lineNumber + "\tAssignment Type Incompatoble");
        		error = true;
        		return null;
        	}
    	} else {
        	variableId = symTabStack.lookupLocal(variableName);
        	if (variableId != null) {
        		TypeSpec typeSpec = variableId.getTypeSpec();
        		Integer localVarNumber = (Integer)variableId.getAttribute(LOCAL_VAR_NUMBER);
        	   	Integer dimension = (Integer)variableId.getAttribute(DIMENSION);
        	   	
        	   	if (dimension != null && dimension > 0) {
        			// Local array variable.
        			jFile.println("\taload\t" + localVarNumber);
        		
        			for (int i = 0 ; i < dimension; i++) {			
        				ParseTree exprTree = ctx.identifier().expr(i);
        				value = visit(exprTree);
        			
        				if (i < dimension-1) {
        					jFile.println("\taaload");
        				}
        			}
        		
        			// Right hand side of assignment statement (expression).
        			ParseTree exprTree = ctx.expr();
        			value = visit(exprTree);
        			
    				if (typeSpec == Predefined.integerType) {
    					jFile.println("\tiastore");
    				} else if (typeSpec == Predefined.realType) {
    					jFile.println("\tfastore");
    				} else if (typeSpec == Predefined.stringType) {
    					jFile.println("\taastore");
    				}
        		
        		} else {
        			// Right hand side of assignment statement (expression).
        			ParseTree exprTree = ctx.expr();
        			value = visit(exprTree);
    			
        			// Local normal variable.
        			String storeInst =  
        					(typeSpec == Predefined.integerType)	? "istore" :
        					(typeSpec == Predefined.realType)		? "fstore" :
        					(typeSpec == Predefined.stringType)	? "astore" :
        					"?store";
    			
        			jFile.println("\t" + storeInst + "\t" + localVarNumber);
        		}
            	// Error Check.
            	TypeSpec rightType = ctx.expr().typeSpec;
            	TypeSpec leftType = variableId.getTypeSpec();
                
            	boolean integerMode =
            			(rightType == Predefined.integerType) &&
            			(leftType == Predefined.integerType);
            	boolean realMode = 
            			(rightType == Predefined.realType) &&
            			(leftType == Predefined.realType);
            	boolean stringMode = 
            			(rightType == Predefined.stringType) &&
            			(leftType == Predefined.stringType);
            	if (!(integerMode || realMode || stringMode)) {
            		System.out.println("Line " + lineNumber + "\tAssignment Type Incompatible");
            		error = true;
            		return null;
            	}
        	} else {
        		// Error Check.
        		System.out.println("Line " + lineNumber + "\tUndeclared Variable: " + variableName);
            	error = true;
        		return null;
        	}
    	}
    	return value; 
    }
    
	@Override
	public Integer visitId(ClangParser.IdContext ctx)
    {
		int lineNumber = ctx.getStart().getLine();
		Integer value = null;

    	String variableName = ctx.identifier().ID().toString();
    	SymTabEntry variableId = symTabStack.lookupGlobal(variableName);    	
    	if (variableId != null) {
			TypeSpec typeSpec = variableId.getTypeSpec();
			ctx.typeSpec = typeSpec;
	    	String typeIndicator =
	    			(typeSpec == Predefined.integerType)	? "I" :
	        		(typeSpec == Predefined.realType)		? "F" :
	        		(typeSpec == Predefined.stringType)	? "Ljava/lang/String;" :
	        		"?";
    	   	Integer dimension = (Integer)variableId.getAttribute(DIMENSION);
    	   	if (dimension != null && dimension > 0) {
	    		// Global array variable.
	    		String arrayNotation = "";
	    		for (int i = 0; i < dimension; i++) {
	    			arrayNotation += "[";
	    		}
	    		jFile.println("\tgetstatic\t" + programId + "/" +  variableName + "\t" +
	    				arrayNotation + typeIndicator);
		
	    		for (int i = 0 ; i < dimension; i++) {			
	    			ParseTree exprTree = ctx.identifier().expr(i);
	    			value = visit(exprTree);
			
	    			if (i < dimension-1) {
	    				jFile.println("\taaload");
	    			} else {
	    				if (typeSpec == Predefined.integerType) {
	    					jFile.println("\tiaload");
	    				} else if (typeSpec == Predefined.realType) {
	    					jFile.println("\tfaload");
	    				} else if (typeSpec == Predefined.stringType) {
	    					jFile.println("\taaload");
	    				}
	    			}
	    		}
	    	} else {
	    		// Global normal variable.
	    		jFile.println("\tgetstatic\t" + programId +
	    				"/" + variableName + " " + typeIndicator);
	    	}
		} else {
        	variableId = symTabStack.lookupLocal(variableName);
        	if (variableId != null) {
        		TypeSpec typeSpec = variableId.getTypeSpec();
        		ctx.typeSpec = typeSpec;
        		Integer localVarNumber = (Integer)variableId.getAttribute(LOCAL_VAR_NUMBER);
        	   	Integer dimension = (Integer)variableId.getAttribute(DIMENSION);
        	   	
        	   	if (dimension != null && dimension > 0) {
        			// Local array variable.
        			jFile.println("\taload\t" + localVarNumber);
        		
        			for (int i = 0 ; i < dimension; i++) {			
        				ParseTree exprTree = ctx.identifier().expr(i);
        				value = visit(exprTree);

        				if (i < dimension-1) {
        					jFile.println("\taaload");
        				} else {
    	    				if (typeSpec == Predefined.integerType) {
    	    					jFile.println("\tiaload");
    	    				} else if (typeSpec == Predefined.realType) {
    	    					jFile.println("\tfaload");
    	    				} else if (typeSpec == Predefined.stringType) {
    	    					jFile.println("\taaload");
    	    				}
        				}
        			}
        		} else {
        			// Local normal variable.
        			String loadInst =  
        					(typeSpec == Predefined.integerType)	? "iload" :
        					(typeSpec == Predefined.realType)		? "fload" :
        					(typeSpec == Predefined.stringType)	? "aload" :
        					"?load";
    			
        			jFile.println("\t" + loadInst + "\t" + localVarNumber);
        		}
        	 // Error Check.
        	} else {
        		System.out.println("Line " + lineNumber + "\tUndeclared Variable: " + variableName);
            	error = true;
        		return null;
        	}
    	}
    	return value;
    }

	@Override public Integer visitParens(ClangParser.ParensContext ctx)
	{
		Integer value = visitChildren(ctx);
		ctx.typeSpec = ctx.expr().typeSpec;
		return value;
	}
	
	@Override 
	public Integer visitAddSub(ClangParser.AddSubContext ctx)
    {
		if (!local) {
			return null;
		}
		int lineNumber = ctx.getStart().getLine();
		Integer value = visitChildren(ctx);
                        
    	TypeSpec rightType = ctx.expr(0).typeSpec;
    	TypeSpec leftType = ctx.expr(1).typeSpec;
        
    	boolean integerMode =
    			(rightType == Predefined.integerType) &&
    			(leftType == Predefined.integerType);
    	boolean realMode = 
    			(rightType == Predefined.realType) &&
    			(leftType == Predefined.realType);
        
		TypeSpec typeSpec =
				integerMode ? Predefined.integerType :
				realMode    ? Predefined.realType :
				null;
		
		// Error Check.
		if (typeSpec == null) {
			System.out.println("Line " + lineNumber +
					"\tOperand Type Incompatible: " + ctx.addSubOp.getText());
			error = true;
			return null;
		}
    	
    	String op = ctx.addSubOp.getText();
    	String opcode;

    	if (op.equals("+")) {
    		opcode =
    			integerMode ? "iadd" :
    			realMode    ? "fadd" :
    			"?add";
        } else {
        	opcode =
        		integerMode ? "isub" :
        		realMode    ? "fsub" :
        		"?sub";
        }
        
    	ctx.typeSpec = typeSpec;
    	
    	// Emit an add or subtract instruction.
    	jFile.println("\t" + opcode);
        
    	return value; 
    }

	@Override 
	public Integer visitMulDivMod(ClangParser.MulDivModContext ctx)
    {
		if (!local) {
			return null;
		}
		int lineNumber = ctx.getStart().getLine();
    	Integer value = visitChildren(ctx);
	                
		TypeSpec rightType = ctx.expr(0).typeSpec;
		TypeSpec leftType = ctx.expr(1).typeSpec;
        
		boolean integerMode =
				(rightType == Predefined.integerType) &&
				(leftType == Predefined.integerType);
		boolean realMode =
        		(rightType == Predefined.realType) &&
        		(leftType == Predefined.realType);
        
		TypeSpec typeSpec =
				integerMode ? Predefined.integerType :
				realMode    ? Predefined.realType :
				null;
		
		// Error Check.
		if (typeSpec == null) {
			System.out.println("Line " + lineNumber +
					"\tOperand Type Incompatible: " + ctx.mulDivModOp.getText());
			error = true;
			return null;
		}

		String op = ctx.mulDivModOp.getText();
		String opcode = "???";

		if (op.equals("*")) {
			opcode =
            	integerMode ? "imul" :
            	realMode    ? "fmul" :
            	"?mul";
		} else if (op.equals("/")) {
        	opcode =
        		integerMode ? "idiv" :
        		realMode    ? "fdiv" :
        		"?div";
        } else {
        	opcode =
            	integerMode ? "irem" :
            	realMode    ? "frem" :
            	"?rem";
        }
		
		ctx.typeSpec = typeSpec;
        
		// Emit a multiply or divide instruction.
		jFile.println("\t" + opcode);
        
		return value; 
    }
	@Override
	public Integer visitSignedExpr(ClangParser.SignedExprContext ctx)
	{
		int lineNumber = ctx.getStart().getLine();
		Integer value = visitChildren(ctx);
    	if (ctx.sign.getText().equals("-")) {
    		
    		try {
    			Integer.parseInt(ctx.expr().getText());
        		// Emit a negate instruction for int.
        		jFile.println("\tineg");
        		
    		} catch (Exception e1) {
        		try {
        			Float.parseFloat(ctx.expr().getText());
            		// Emit a negate instruction for double.
            		jFile.println("\tfneg");
            		
        		} catch (Exception e2) {
        			System.out.println("Unegatable Expression: " + lineNumber);
        		}
    		}
    	}
    	ctx.typeSpec = ctx.expr().typeSpec;
		return value;
	}
	@Override 
	public Integer visitIntNum(ClangParser.IntNumContext ctx)
    {
		if (!local) {
			return null;
		}
    	String number = ctx.getText();
    	ctx.typeSpec = Predefined.integerType;
    	
    	if (number.startsWith("-")) {
    		// Emit a load constant instruction.
    		jFile.println("\tldc\t" + number.substring(1));
    		// Emit a negate instruction.
    		jFile.println("\tineg");
    		
    	} else if (number.startsWith("+")) {
    		// Emit a load constant instruction.
    		jFile.println("\tldc\t" + number.substring(1));
    		
    	} else {
    		// Emit a load constant instruction.
    		jFile.println("\tldc\t" + number);
        }
        
    	return visitChildren(ctx);
    }
    
	@Override 
	public Integer visitDoubleNum(ClangParser.DoubleNumContext ctx)
    {
		if (!local) {
			return null;
		}
    	String number = ctx.getText();
    	ctx.typeSpec = Predefined.realType;
    	
    	if (number.startsWith("-")) {
    		// Emit a load constant instruction.
    		jFile.println("\tldc\t" + number.substring(1));
    		// Emit a negate instruction.
    		jFile.println("\tfneg");

    	} else if (number.startsWith("+")) {
    		// Emit a load constant instruction.
    		jFile.println("\tldc\t" + number.substring(1));
    		
    	} else {
    		// Emit a load constant instruction.
    		jFile.println("\tldc\t" + number);
        }
        
    	return visitChildren(ctx);
    }
    
	@Override
	public Integer visitStrValue(ClangParser.StrValueContext ctx)
    {
		if (!local) {
			return null;
		}
    	String str = ctx.getText();
    	ctx.typeSpec = Predefined.stringType;
    	
    	// Emit a load constant instruction.
    	jFile.println("\tldc\t" + str);
        
    	return visitChildren(ctx);
    }
    
	@Override
	public Integer visitRelativity(ClangParser.RelativityContext ctx)
    {
		int lineNumber = ctx.getStart().getLine();
    	countRelOp++;
    	int currentCountRelOp = countRelOp;
    	
    	Integer value = visitChildren(ctx);
    	
		TypeSpec rightType = ctx.expr(0).typeSpec;
		TypeSpec leftType = ctx.expr(1).typeSpec;
        
		boolean integerMode =
				(rightType == Predefined.integerType) &&
				(leftType == Predefined.integerType);
		boolean realMode =
        		(rightType == Predefined.realType) &&
        		(leftType == Predefined.realType);	
		
		// Emit a if_icmp instruction.
		String relOp = ctx.relOp.getText();
		if (integerMode || realMode) {
			String relInst;
			if (relOp.equals("<")) {
				relInst = "if_icmplt";
			} else if (relOp.equals("<=")) {
				relInst = "if_icmple";
			} else if (relOp.equals(">")) {
				relInst = "if_icmpgt";
			} else if (relOp.equals(">=")) {
				relInst = "if_icmpge";
			} else {
				relInst = "if_icmp??";
			}
    	
			jFile.println("\t" + relInst + "\tTRUE_REL" + currentCountRelOp);
			jFile.println("\ticonst_0");
			jFile.println("\tgoto\tEND_REL" + currentCountRelOp);
			jFile.println("TRUE_REL" + currentCountRelOp + ":");
			jFile.println("\ticonst_1");
			jFile.println("END_REL" + + currentCountRelOp + ":");
			
			ctx.typeSpec = Predefined.integerType;
		
		// Error check.
		} else {
			System.out.println("Line " + lineNumber + "\tOperand Type Incompatible: " + relOp);
			error = true;
			return null;
		}

    	return value;
    }
    
	@Override
	public Integer visitEquality(ClangParser.EqualityContext ctx)
    {
		int lineNumber = ctx.getStart().getLine();
    	countEqOp++;
    	int currentCountEqOp = countEqOp;
    	
    	Integer value = visitChildren(ctx);
    	
		TypeSpec rightType = ctx.expr(0).typeSpec;
		TypeSpec leftType = ctx.expr(1).typeSpec;
        
		boolean integerMode =
				(rightType == Predefined.integerType) &&
				(leftType == Predefined.integerType);
		boolean realMode =
        		(rightType == Predefined.realType) &&
        		(leftType == Predefined.realType);
		
		// Emit a if_icmp instruction.
		String eqOp = ctx.eqOp.getText();
		if (integerMode || realMode) {
			String eqInst;
			if (eqOp.equals("==")) {
				eqInst = "if_icmpeq";
			} else if (eqOp.equals("!=")) {
				eqInst = "if_icmpne";
			} else {
				eqInst = "if_icmp??";
			}
    	
			jFile.println("\t" + eqInst + "\tTRUE_EQ" + currentCountEqOp);
			jFile.println("\ticonst_0");
			jFile.println("\tgoto\tEND_EQ" + currentCountEqOp);
			jFile.println("TRUE_EQ"  + currentCountEqOp + ":");
			jFile.println("\ticonst_1");
			jFile.println("END_EQ" + currentCountEqOp + ":");
			
			ctx.typeSpec = Predefined.integerType;
		
		// Error check.
		} else {
			System.out.println("Line " + lineNumber + "\tOperand Type Incompatible: " + eqOp);
			error = true;
			return null;
		}
		
    	return value;
    }
    
	@Override public Integer visitAnd(ClangParser.AndContext ctx)
	{
		int lineNumber = ctx.getStart().getLine();
		Integer value;
		countAnd++;
		int currentCountAnd = countAnd;
		
		ParseTree exprTree = ctx.expr(0);
		value = visit(exprTree);
		
		jFile.println("\tifeq\tFALSE_AND" + currentCountAnd);
		
		exprTree = ctx.expr(1);
		value = visit(exprTree);
		
		TypeSpec left = ctx.expr(0).typeSpec;
		TypeSpec right = ctx.expr(1).typeSpec;
		
		if (left == Predefined.integerType && right == Predefined.integerType) {
			jFile.println("\tifeq\tFALSE_AND" + currentCountAnd);
			jFile.println("\ticonst_1");
			jFile.println("\tgoto\tEND_AND" + currentCountAnd);
			jFile.println("FALSE_AND" + currentCountAnd + ":");
			jFile.println("\ticonst_0");
			jFile.println("END_AND" + currentCountAnd + ":");
			
			ctx.typeSpec = Predefined.integerType;
		
		// Error check.
		} else {
			System.out.println("Line " + lineNumber + "\tOperand Type Incompatible: &&");
			error = true;
			return null;
		}
		
		return value;
	}
	
	@Override public Integer visitOr(ClangParser.OrContext ctx)
	{
		int lineNumber = ctx.getStart().getLine();
		Integer value;
		countOr++;
		int currentCountOr = countOr;
		
		ParseTree exprTree = ctx.expr(0);
		value = visit(exprTree);
		
		jFile.println("\tifne\tTRUE_OR" + currentCountOr);
		
		exprTree = ctx.expr(1);
		value = visit(exprTree);
		
		TypeSpec left = ctx.expr(0).typeSpec;
		TypeSpec right = ctx.expr(1).typeSpec;
		
		if (left == Predefined.integerType && right == Predefined.integerType) {	
			jFile.println("\tifne\tTRUE_OR" + currentCountOr);
			jFile.println("\ticonst_0");
			jFile.println("\tgoto\tEND_OR" + currentCountOr);
			jFile.println("TRUE_OR" + currentCountOr + ":");
			jFile.println("\ticonst_1");
			jFile.println("END_OR" + currentCountOr + ":");
			
			ctx.typeSpec = Predefined.integerType;
			
		// Error check.	
		} else {
			System.out.println("Line " + lineNumber + "\tOperand Type Incompatible: ||");
			error = true;
			return null;
		}
		return value;
	}
	
	@Override public Integer visitNot(ClangParser.NotContext ctx)
	{
		int lineNumber = ctx.getStart().getLine();
		Integer value;
		countNot++;
		int correntCountNot = countNot;
	
		ParseTree exprTree = ctx.expr();
		value = visit(exprTree);
		
		TypeSpec typeSpec = ctx.expr().typeSpec;
		
		if (typeSpec != Predefined.integerType) {
			jFile.println("\tifeq\tTRUE_NOT" + correntCountNot);
			jFile.println("\ticonst_0");
			jFile.println("\tgoto\tEND_NOT" + correntCountNot);
			jFile.println("TRUE_NOT" + correntCountNot + ":");
			jFile.println("\ticonst_1");
			jFile.println("END_NOT" + correntCountNot + ":");
			
			ctx.typeSpec = Predefined.integerType;
			
		// Error check.	
		} else {
			System.out.println("Line " + lineNumber + "\tOperand Type Incompatible: !");
			error = true;
			return null;
		}
		
		return value;
	}
    
	@Override
	public Integer visitWhile_stmt(ClangParser.While_stmtContext ctx)
    {
    	boolean currentInsideFor = insideFor;
    	insideFor = false;
		insideWhile = true;
		
    	countWhile++;
    	int currentCountWhile = countWhile;
    	
    	jFile.println("WHILE_START" + currentCountWhile + ":");
    	ParseTree exprTree = ctx.expr();
    	Integer value = visit(exprTree);
    	jFile.println("\tifeq\tWHILE_END" + currentCountWhile);
    	
    	ParseTree blockTree = ctx.block();
    	value = visit(blockTree);
    	
    	jFile.println("\tgoto\tWHILE_START" + currentCountWhile);
    	jFile.println("WHILE_END" + currentCountWhile + ":");
    	
    	insideWhile = false;
    	insideFor = currentInsideFor;
    	
    	return value;
    }
	
	@Override public
	Integer visitFor_stmt(ClangParser.For_stmtContext ctx)
	{
    	boolean currentInsideWhile = insideWhile;
    	insideWhile = false;
    	insideFor = true;
    	
    	countFor++;
    	int currentCountFor = countFor;
    	
    	// First Expression
    	ParseTree exprTree = ctx.for_init();
    	Integer value = visit(exprTree);
    	
    	jFile.println("FOR_START" + currentCountFor + ":");
    	
    	// Second Expression
    	exprTree = ctx.expr();
    	value = visit(exprTree);
    	
    	jFile.println("\tifeq\tFOR_END" + currentCountFor);
    	
    	// Inside for loop
    	ParseTree blockTree = ctx.block();
    	value = visit(blockTree);
    	
    	// Third Expression
    	exprTree = ctx.for_end();
    	value = visit(exprTree);
    	
    	jFile.println("\tgoto\tFOR_START" + currentCountFor);
    	jFile.println("FOR_END" + currentCountFor + ":");
    	
    	insideFor = false;
    	insideWhile = currentInsideWhile;
    	
    	return value;
	}
    
	@Override
	public Integer visitIf_stmt(ClangParser.If_stmtContext ctx)
	{
    	countIf++;
    	int currentCountIf = countIf;
    	
    	jFile.println("IF_START" + currentCountIf + ":");
    	ParseTree exprTree = ctx.expr();
    	Integer value = visit(exprTree);
    	
    	ParseTree blockTree;
    	if (ctx.ELSE() == null) {
    		// No ELSE statement
    		jFile.println("\tifeq\tIF_END" + currentCountIf);
        	blockTree = ctx.block(0);
        	value = visit(blockTree);

    	} else {
    		// There is an ELSE statement
    		jFile.println("\tifeq\tELSE" + currentCountIf);
        	blockTree = ctx.block(0);
        	value = visit(blockTree);
        	
        	jFile.println("\tgoto\tIF_END" + currentCountIf);
        	jFile.println("ELSE" + currentCountIf + ":");
        	
        	blockTree = ctx.block(1);
        	value = visit(blockTree);
    	}
    	
    	jFile.println("IF_END" + currentCountIf + ":");
    	
    	return value;
	}
    
	@Override
	public Integer visitBreak_stmt(ClangParser.Break_stmtContext ctx)
    {
    	if (insideWhile) {
    		String label = "WHILE_END" + countWhile;
    		jFile.println("\tgoto\t" + label);
    		
    	} else if (insideFor) {
    		String label = "FOR_END" + countFor;
    		jFile.println("\tgoto\t" + label);
    	}
    	return visitChildren(ctx);
    }
    
	@Override
	public Integer visitRtn_stmt(ClangParser.Rtn_stmtContext ctx)
	{
		int lineNumber = ctx.getStart().getLine();
		
		// If in the middle of parsing main function, ignore return statement.
		if (parsingMain) {
			return null;
		}
		
		Integer value = visitChildren(ctx);

		jFile.flush();
    	if (ctx.expr() != null) {
    		TypeSpec typeSpec = ctx.expr().typeSpec;
    		
    		// Error.
    		if (currentRtnType != typeSpec) {
    			System.out.println("Line " + lineNumber +
    					"\tReturn Type Mismatch");
    			error = true;
    			return null;
    		}
    		
    		if (typeSpec == Predefined.integerType) {
    			jFile.println("\tireturn");
    		} else if (typeSpec == Predefined.realType) {
    			jFile.println("\tfreturn");
    		} else if (typeSpec == Predefined.stringType) {
    			jFile.println("\tareturn");
    		} else {
    			// Error.
    			System.out.println("Line " + lineNumber +
    					"\tInvalid Return Expression: " + ctx.expr().getText());
    			error = true;
    			return null;
    		}
    	} else {
    		jFile.println("\treturn");
    	}
    	return value;
    }
	
	@Override
	public Integer visitInc_dec_stmt(ClangParser.Inc_dec_stmtContext ctx)
	{
		int lineNumber = ctx.getStart().getLine();
    	Integer value = null;

    	String variableName = ctx.identifier().ID().toString();
    	SymTabEntry variableId = symTabStack.lookupGlobal(variableName);
    	if (variableId != null) {
    		TypeSpec typeSpec = variableId.getTypeSpec();
    		
    		// Error
    		if (typeSpec != Predefined.integerType) {
    			System.out.println("Line " + lineNumber + "\tInvalid Increment or Decrement");
    			error = true;
    			return null;
    		}
    		
    	   	Integer dimension = (Integer)variableId.getAttribute(DIMENSION);
    	    if (dimension != null && dimension > 0) {
    	    	// Global array variable.
    	   		String arrayNotation = "";
    	    	for (int i = 0; i < dimension; i++) {
    	    		arrayNotation += "[";
    	    	}
    	    	jFile.println("\tgetstatic\t" + programId + "/" +  variableName + "\t" +
    	    			arrayNotation + "I");

            	for (int i = 0 ; i < dimension; i++) {			
          			ParseTree exprTree = ctx.identifier().expr(i);
          			value = visit(exprTree);
            			
          			if (i < dimension-1) {
          				jFile.println("\taaload");
          			}
           		}
            	
    	    	// Increment or decrement by 1.
    	    	jFile.println("\tgetstatic\t" + programId + "/" +  variableName + "\t" +
    	    			arrayNotation + "I");
     			for (int i = 0 ; i < dimension; i++) {			
    				ParseTree exprTree = ctx.identifier().expr(i);
    				value = visit(exprTree);
    			
    				if (i < dimension-1) {
    					jFile.println("\taaload");
    				}
    			}
     			
				if (typeSpec == Predefined.integerType) {
					jFile.println("\tiaload");
				} else if (typeSpec == Predefined.realType) {
					jFile.println("\tfaload");
				} else if (typeSpec == Predefined.stringType) {
					jFile.println("\taaload");
				}
				
    	    	jFile.println("\tldc\t1");
    	    	if (ctx.INC_DEC().getText().equals("++")) {
    	    		jFile.println("\tiadd");
    	    	} else {
    	    		jFile.println("\tisub");
    	    	}
    			
				if (typeSpec == Predefined.integerType) {
					jFile.println("\tiastore");
				} else if (typeSpec == Predefined.realType) {
					jFile.println("\tfastore");
				} else if (typeSpec == Predefined.stringType) {
					jFile.println("\taastore");
				}
    				
    	    } else {
    	    	// Increment or decrement by 1.
    	    	jFile.println("\tgetstatic\t" + programId + "/" + variableName + "\tI");
    	    	jFile.println("\tldc\t1");
    	    	if (ctx.INC_DEC().getText().equals("++")) {
    	    		jFile.println("\tiadd");
    	    	} else {
    	    		jFile.println("\tisub");
    	    	}
    	    	jFile.println("\tputstatic\t" + programId + "/" + variableName + "\tI");
    	    }
    	} else {
        	variableId = symTabStack.lookupLocal(variableName);
        	if (variableId != null) {
        		TypeSpec typeSpec = variableId.getTypeSpec();
        		
        		// Error
        		if (typeSpec != Predefined.integerType) {
        			System.out.println("Line " + lineNumber + "\tInvalid Increment or Decrement");
        			error = true;
        			return null;
        		}
        		
        		Integer localVarNumber = (Integer)variableId.getAttribute(LOCAL_VAR_NUMBER);
        	   	Integer dimension = (Integer)variableId.getAttribute(DIMENSION);
        	   	
        	   	if (dimension != null && dimension > 0) {
        			// Local array variable.
        			jFile.println("\taload\t" + localVarNumber);
        			
        			for (int i = 0 ; i < dimension; i++) {			
        				ParseTree exprTree = ctx.identifier().expr(i);
        				value = visit(exprTree);
        			
        				if (i < dimension-1) {
        					jFile.println("\taaload");
        				}
        			}
        			
        	    	// Increment or decrement by 1.
        	    	jFile.println("\taload\t" + localVarNumber);
         			for (int i = 0 ; i < dimension; i++) {			
        				ParseTree exprTree = ctx.identifier().expr(i);
        				value = visit(exprTree);
        			
        				if (i < dimension-1) {
        					jFile.println("\taaload");
        				}
        			}
         			
    				if (typeSpec == Predefined.integerType) {
    					jFile.println("\tiaload");
    				} else if (typeSpec == Predefined.realType) {
    					jFile.println("\tfaload");
    				} else if (typeSpec == Predefined.stringType) {
    					jFile.println("\taaload");
    				}
    				
        	    	jFile.println("\tldc\t1");
        	    	if (ctx.INC_DEC().getText().equals("++")) {
        	    		jFile.println("\tiadd");
        	    	} else {
        	    		jFile.println("\tisub");
        	    	}
        	    	
    				if (typeSpec == Predefined.integerType) {
    					jFile.println("\tiastore");
    				} else if (typeSpec == Predefined.realType) {
    					jFile.println("\tfastore");
    				} else if (typeSpec == Predefined.stringType) {
    					jFile.println("\taastore");
    				}
        		
        		} else {
        	    	// Increment or decrement by 1.
        			jFile.println("\tiload\t" + localVarNumber);

        	    	jFile.println("\tldc\t1");
        	    	if (ctx.INC_DEC().getText().equals("++")) {
        	    		jFile.println("\tiadd");
        	    	} else {
        	    		jFile.println("\tisub");
        	    	}
        			jFile.println("\tistore\t" + localVarNumber);
        		}
        	}
    	}
    	return value; 
	}
    
	@Override
	public Integer visitFuncCall(ClangParser.FuncCallContext ctx)
	{
		int lineNumber = ctx.getStart().getLine();
		Integer value = null;
		
		// Built-in printf function.
		String funcName = ctx.func_call().ID().getText();
		if (funcName.equals("printf")) {
			ArrayList<ClangParser.ExprContext> exprs =
					new ArrayList<>(ctx.func_call().actual_arg_list().expr());
			int countArgs = exprs.size();
			
			jFile.println("\tgetstatic java/lang/System/out Ljava/io/PrintStream;");
			
			ParseTree exprTree = ctx.func_call().actual_arg_list().expr(0);
			value = visit(exprTree);

			if (countArgs > 1) {
				// Format string + arguments.
				jFile.println("\tldc\t" + (countArgs-1));
				jFile.println("\tanewarray\tjava/lang/Object");
				for (int i = 1; i < countArgs; i++) {
					
					jFile.println("\tdup");
					jFile.println("\tldc\t" + (i-1));
					
					exprTree = ctx.func_call().actual_arg_list().expr(i);
					value = visit(exprTree);
				
					TypeSpec typeSpec = exprs.get(i).typeSpec;
					String typeIndicator =
							(typeSpec == Predefined.integerType)	? "I" :
							(typeSpec == Predefined.realType)		? "F" :
							(typeSpec == Predefined.stringType)	? "Ljava/lang/String;" :
																		  "?";
					
					if (typeSpec != Predefined.stringType) {
						String typeClassName = 
								(typeSpec == Predefined.integerType)	? "Integer" :
								(typeSpec == Predefined.realType)		? "Float" :
								"??????";
						
						jFile.println("\tinvokestatic\tjava/lang/" + typeClassName + ".valueOf(" +
								typeIndicator + ")Ljava/lang/" + typeClassName + ";");
					}
					jFile.println("\taastore");  	
				}
				jFile.println(
						"\tinvokevirtual\tjava/io/PrintStream.printf(Ljava/lang/String;" +
						"[Ljava/lang/Object;)Ljava/io/PrintStream;");
				jFile.println("\tpop");
				
			} else {
				jFile.println(
						"\tinvokevirtual\tjava/io/PrintStream.print(Ljava/lang/String;)V");
			}
		// Built-in input function.
		} else if (funcName.equals("input")) {
			if (ctx.func_call().actual_arg_list().expr().size() == 0) {
				jFile.println("\tgetstatic\t" + programId + "/_scanner\tLjava/util/Scanner;");
				jFile.println("\tinvokevirtual\tjava/util/Scanner/nextLine()Ljava/lang/String;");
				ctx.typeSpec = Predefined.stringType;
			} else {
				System.out.println("Line " + lineNumber + "\tArgument Mismatch: input");
				error = true;
				return null;
			}
		
		// Built-in stoi(string to int) function.
		} else if (funcName.equals("stoi")) {
			if (ctx.func_call().actual_arg_list().expr().size() == 1) {
				ParseTree exprTree = ctx.func_call().actual_arg_list().expr(0);
				value = visit(exprTree);
				if (ctx.func_call().actual_arg_list().expr(0).typeSpec == Predefined.stringType) {
					jFile.println("\tinvokestatic\tjava/lang/Integer/valueOf(Ljava/lang/String;)Ljava/lang/Integer;");
					jFile.println("\tinvokevirtual\tjava/lang/Integer/intValue()I");
					ctx.typeSpec = Predefined.integerType;
				} else {
					System.out.println("Line " + lineNumber + "\tArgument Mismatch: stoi");
					error = true;
					return null;
				}
			} else {
				System.out.println("Line " + lineNumber + "\tArgument Mismatch: stoi");
				error = true;
				return null;
			}
		// Built-in stod(string to double) function.
		} else if (funcName.equals("stod")) {
			if (ctx.func_call().actual_arg_list().expr().size() == 1) {
				ParseTree exprTree = ctx.func_call().actual_arg_list().expr(0);
				value = visit(exprTree);
				if (ctx.func_call().actual_arg_list().expr(0).typeSpec == Predefined.stringType) {
					jFile.println("\tinvokestatic\tjava/lang/Float/valueOf(Ljava/lang/String;)Ljava/lang/Float;");
					jFile.println("\tinvokevirtual\tjava/lang/Float/floatValue()F");
					ctx.typeSpec = Predefined.realType;
				} else {
					System.out.println("Line " + lineNumber + "\tArgument Mismatch: stod");
					error = true;
					return null;
				}
			} else {
				System.out.println("Line " + lineNumber + "\tArgument Mismatch: stod");
				error = true;
				return null;
			}
		// Built-in rand function
		} else if (funcName.equals("rand")) {
			if (ctx.func_call().actual_arg_list().expr().size() == 0) {
				jFile.println("\tnew java/util/Random");
				jFile.println("\tdup");
				jFile.println("\tinvokenonvirtual\tjava/util/Random/<init>()V");
				jFile.println("\tinvokevirtual\tjava/util/Random/nextInt()I");
				ctx.typeSpec = Predefined.integerType;
				
			// Error check.
			} else {
				System.out.println("Line " + lineNumber + "\tArgument Mismatch: rand");
				error = true;
				return null;
			}
		} else {
			// User-defined functions.
			List<ClangParser.ExprContext> actualArgExprs =
					(List<ClangParser.ExprContext>)ctx.func_call().actual_arg_list().expr();
		
			String argTypeIndicator = "";
			
			SymTabEntry funcId = symTabStack.lookup(funcName);
			
			// Error Check.
			if (funcId == null) {
	    		System.out.println("Line " + lineNumber + "\tUndeclared Function: " + funcName);
	    		error = true;
	    		return null;
				
			}
			if (funcId.getDefinition() == FUNCTION) {
				TypeSpec typeSpec = funcId.getTypeSpec();
				String rtnTypeIndicator =
	        		(typeSpec == Predefined.integerType)	? "I" :
	        		(typeSpec == Predefined.realType)		? "F" :
	        		(typeSpec == Predefined.stringType)	? "Ljava/lang/String;" :
	        		(typeSpec == Predefined.voidType)		? "V" :
	        		"?";
					
				ctx.typeSpec = typeSpec;
			
				// Error check.
				@SuppressWarnings("unchecked")
				ArrayList<SymTabEntry> formalArgs =
						(ArrayList<SymTabEntry>)funcId.getAttribute(FORMAL_ARGS);
				if (formalArgs.size() != actualArgExprs.size()) {
		    		System.out.println("Line " + lineNumber + "\tArgument Mismatch: " + funcName);
		    		error = true;
		    		return null;
				}
				
				for (int i = 0; i < actualArgExprs.size(); i++) {
					String actualArgName = actualArgExprs.get(i).getText();
					
					SymTabEntry variableId = symTabStack.lookupLocal(actualArgName);
					if (variableId != null) {
						
						// Error check.
						if (formalArgs.get(i).getTypeSpec() != variableId.getTypeSpec()) {
				    		System.out.println("Line " + lineNumber + "\tArgument Mismatch: " + funcName);
				    		error = true;
				    		return null;
						}
						
						Integer localVarNumber = (Integer)variableId.getAttribute(LOCAL_VAR_NUMBER);
						Integer dimension = (Integer)variableId.getAttribute(DIMENSION);

						if (dimension != null && dimension > 0) {
							
							// Passing local array
							for (int j = 0; j < dimension; j++) {
								argTypeIndicator += "[";
							}
							
							typeSpec = variableId.getTypeSpec();
							argTypeIndicator +=
									(typeSpec == Predefined.integerType)	? "I" :
									(typeSpec == Predefined.realType)		? "F" :
									(typeSpec == Predefined.stringType)	? "Ljava/lang/String;" :
									"?";
							jFile.println("\taload\t" + localVarNumber);
						} else {
							// Passing local variable
							ParseTree exprTree  = actualArgExprs.get(i);
							value = visit(exprTree);
					
							typeSpec = actualArgExprs.get(i).typeSpec;
							argTypeIndicator +=
									(typeSpec == Predefined.integerType)	? "I" :
									(typeSpec == Predefined.realType)		? "F" :
									(typeSpec == Predefined.stringType)	? "Ljava/lang/String;" :
									"?";
						}
					} else {
						variableId = symTabStack.lookupGlobal(actualArgName);
						if (variableId != null) { 
							
							// Error check.
							if (formalArgs.get(i).getTypeSpec() != variableId.getTypeSpec()) {
					    		System.out.println("Line " + lineNumber + "\tArgument Mismatch: " + funcName);
					    		error = true;
					    		return null;
							}
							
							actualArgName = variableId.getName();
			    			Integer dimension = (Integer)variableId.getAttribute(DIMENSION);
							
							if (dimension != null && dimension > 0) {
								
								// Passing global array
								for (int j = 0; j < dimension; j++) {
									argTypeIndicator += "[";
								}
								typeSpec = variableId.getTypeSpec();
								argTypeIndicator +=
										(typeSpec == Predefined.integerType)	? "I" :
										(typeSpec == Predefined.realType)		? "F" :
										(typeSpec == Predefined.stringType)	? "Ljava/lang/String;" :
										"?";
								jFile.println("\tgetstatic\t" + programId + "/" + actualArgName + "\t" + argTypeIndicator);
							} else {
								// Passing global variable
								ParseTree exprTree  = actualArgExprs.get(i);
								value = visit(exprTree);
							
								typeSpec = actualArgExprs.get(i).typeSpec;
								argTypeIndicator +=
										(typeSpec == Predefined.integerType)	? "I" :
										(typeSpec == Predefined.realType)		? "F" :
										(typeSpec == Predefined.stringType)	? "Ljava/lang/String;" :
										"?";
							}
						} else {
							// Passing expression
							ParseTree exprTree  = actualArgExprs.get(i);
							value = visit(exprTree);
						
							typeSpec = actualArgExprs.get(i).typeSpec;
							argTypeIndicator +=
									(typeSpec == Predefined.integerType)	? "I" :
									(typeSpec == Predefined.realType)		? "F" :
									(typeSpec == Predefined.stringType)	? "Ljava/lang/String;" :
									"?";
						}
					} 
				}
				jFile.println("\tinvokestatic " + programId + "/" + funcName +
						"(" + argTypeIndicator+")" + rtnTypeIndicator);
			}
		}
		return value;
	}
	
	@Override
	public Integer visitFunc(ClangParser.FuncContext ctx)
	{
		local = true;
		symTabStack.push();
		
		String funcName = ctx.ID().getText();
		jFile.println();
		jFile.print(".method private static " + funcName + "(");
		
		StringBuilder localVarAlloc = new StringBuilder();

		// Argument types.
		countLocalVars = 0;
		List<ClangParser.TypeContext> argTypes =
				(List<ClangParser.TypeContext>)ctx.formal_args().type();
		int countFormalArgs = argTypes.size();
		
		SymTabEntry funcId = symTabStack.lookupGlobal(funcName);
		ArrayList<SymTabEntry> formalArgs = new ArrayList<>(); 
		
		for (int i = 0; i < countFormalArgs; i++) {
			String variableName = ctx.formal_args().argument(i).ID().getText();
			SymTabEntry variableId = symTabStack.enterLocal(variableName);
    	
			String argType = argTypes.get(i).getText();
			TypeSpec typeSpec =
					(argType.equals("int"))		? Predefined.integerType :
					(argType.equals("double"))	? Predefined.realType :
					(argType.equals("string"))	? Predefined.stringType :
					null;
			variableId.setTypeSpec(typeSpec);
			variableId.setAttribute(LOCAL_VAR_NUMBER, countLocalVars);
			
			String typeIndicator = "";
			if (ctx.formal_args().argument(i).BRAKETS() != null) {
				int dimension = ctx.formal_args().argument(i).BRAKETS().size();
				for (int j = 0; j < dimension; j++) {
					typeIndicator += "[";
				}
				variableId.setAttribute(DIMENSION, dimension);
			}
			
			formalArgs.add(variableId);
			
			typeIndicator +=
					(argType.equals("int"))		? "I" :
					(argType.equals("double"))	? "F" :
					(argType.equals("string"))	? "Ljava/lang/String;" :
					"?";
	    	jFile.print(typeIndicator);
	    	
	    	localVarAlloc.append("\n.var ");
	    	localVarAlloc.append(countLocalVars);
	    	localVarAlloc.append(" is ");
	    	localVarAlloc.append(variableName);
	    	localVarAlloc.append(" ");
	    	localVarAlloc.append(typeIndicator);
	    	localVarAlloc.append("\n");
	    	
	    	countLocalVars++;
		}
		jFile.print(")");
		
		funcId.setAttribute(FORMAL_ARGS, formalArgs);
		
		// Return type.
		String returnType = ctx.type().getText();
		String typeIndicator =
        		(returnType.equals("int"))		? "I" :
        		(returnType.equals("double"))	? "F" :
        		(returnType.equals("string"))	? "Ljava/lang/String;" :
        		(returnType.equals("void"))		? "V" :
        		"?";
    	jFile.println(typeIndicator);
    	jFile.print(localVarAlloc.toString());
    	
    	currentRtnType = 
        		(returnType.equals("int"))		? Predefined.integerType :
        		(returnType.equals("double"))	? Predefined.realType :
        		(returnType.equals("string"))	? Predefined.stringType :
        		(returnType.equals("void"))		? Predefined.voidType :
        		null;
    	
		Integer value =  visitChildren(ctx);
		currentRtnType = null;
		
		jFile.println(".limit locals " + countLocalVars);
		jFile.println(".limit stack 64");
		jFile.println(".end method");
		
		symTabStack.pop();
    	local = false;
		return value;	
	}
	
	@Override
	public Integer visitLocal_var_decl(ClangParser.Local_var_declContext ctx)
	{
		int lineNumber = ctx.getStart().getLine();
		Integer value = null;
		
		// Local variables.		
		String type = ctx.type().getText();
    	String typeIndicator =
        		(type.equals("int"))		? "I" :
        		(type.equals("double"))	? "F" :
        		(type.equals("string"))	? "Ljava/lang/String;" :
        		"?";
		ArrayList<ClangParser.IdentifierContext> localVars =
				(ArrayList<ClangParser.IdentifierContext>)ctx.local_var_list().identifier();

    	for (int i = 0; i < localVars.size(); i++) {
	    	String localVarName = localVars.get(i).ID().getText();
	    	
	    	SymTabEntry variableId = symTabStack.lookupLocal(localVarName);
	    	// Error.
	    	if (variableId != null) {
	    		System.out.println("Line " + lineNumber + "\tDepulicate Variable: " + localVarName);
	    		error = true;
	    		return null;
	    	}
	    		
			List<ClangParser.ExprContext> subscripts =
					(List<ClangParser.ExprContext>)localVars.get(i).expr();
	    	int dimension = subscripts.size();
	    	String arrayNotation = "";
			for (int j = 0; j < dimension; j++) {
				arrayNotation += "[";
			}
			typeIndicator = arrayNotation + typeIndicator;
    		
    		StringBuilder localVarAlloc = new StringBuilder();
	    	localVarAlloc.append("\n.var ");
	    	localVarAlloc.append(countLocalVars);
	    	localVarAlloc.append(" is ");
	    	localVarAlloc.append(localVarName);
	    	localVarAlloc.append(" ");
	    	localVarAlloc.append(typeIndicator);
	    	
    		variableId = symTabStack.enterLocal(localVarName);
	    	TypeSpec typeSpec =
	        		(type.equals("int"))		? Predefined.integerType :
	        		(type.equals("double"))	? Predefined.realType :
	        		(type.equals("string"))	? Predefined.stringType :
	        		null;
	    	variableId.setTypeSpec(typeSpec);
	    	variableId.setAttribute(LOCAL_VAR_NUMBER, countLocalVars);
	    	
	    	jFile.println(localVarAlloc.toString());
	    	
	    	// Initialize local variable
	    	if (ctx.local_var_list().expr(i) != null) {
	    		ParseTree exprTree = ctx.local_var_list().expr(i);
	    		value = visit(exprTree);
	    		typeSpec = ctx.local_var_list().expr(i).typeSpec;
	        	String storeInst =
	            		(typeSpec == Predefined.integerType)	? "istore" :
	            		(typeSpec == Predefined.realType)		? "fstore" :
	            		(typeSpec == Predefined.stringType)	? "astore" :
	            		"?store";
	        	
            	// Type Checking.
            	TypeSpec rightType = typeSpec;
            	TypeSpec leftType = variableId.getTypeSpec();
                
            	boolean integerMode =
            			(rightType == Predefined.integerType) &&
            			(leftType == Predefined.integerType);
            	boolean realMode = 
            			(rightType == Predefined.realType) &&
            			(leftType == Predefined.realType);
            	boolean stringMode = 
            			(rightType == Predefined.stringType) &&
            			(leftType == Predefined.stringType);
            	
            	if (!(integerMode || realMode || stringMode)) {
            		System.out.println("Line " + lineNumber + "\tAssignment Type Incompatible");
            		error = true;
            		return null;
            	}
	    		
	    		jFile.println("\t" + storeInst + "\t" + countLocalVars);
	    	}
	    	
	    	// Initialize if it's an array.
			if (dimension > 0) {
				// Local Array
    			variableId.setAttribute(SUBSCRIPTS, subscripts);
    			variableId.setAttribute(DIMENSION, dimension);

				for (int j = 0; j < dimension; j++) {
					ParseTree exprTree = subscripts.get(j);
					value = visit(exprTree);
				}
				
    			if (subscripts.size() == 1) {
    				// One-dimensional array.
    				if (variableId.getTypeSpec() == Predefined.integerType) {
    					jFile.println("\tnewarray\tint");
    					
    				} else if (variableId.getTypeSpec() == Predefined.realType) {
    					jFile.println("\tnewarray\tfloat");

    				} else if (variableId.getTypeSpec() == Predefined.stringType) {
    					jFile.println("\tanewarray\tjava/lang/String");
    				}
    			} else {
    				// Multidimensional array.
    				jFile.println("\tmultianewarray\t" + typeIndicator + "\t" + dimension);
    				
    			}
    			jFile.println("\tastore\t" + countLocalVars);
    		}
	    	countLocalVars++;
    	}
    	
		return value;
	}
}