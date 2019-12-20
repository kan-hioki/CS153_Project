import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTree;

import wci.intermediate.*;
import wci.intermediate.symtabimpl.*;
import wci.util.*;

import static wci.intermediate.symtabimpl.SymTabKeyImpl.*;
import static wci.intermediate.symtabimpl.DefinitionImpl.*;

public class Pass1Visitor extends ClangBaseVisitor<Integer> 
{
	private SymTabStack symTabStack;
	private SymTabEntry programId;
	private ArrayList<SymTabEntry> variableIdList;
	private PrintWriter jFile;
	private boolean global;
	private String inputFileName;
	private boolean error;
    
	public Pass1Visitor(String inputFileName)
	{
		// Create and initialize the symbol table stack.
		symTabStack = SymTabFactory.createSymTabStack();
		Predefined.initialize(symTabStack);
		this.inputFileName = inputFileName;
		error = false;
	}
    
	public ArrayList<SymTabEntry> getvariableIdList() { return variableIdList; }
	public PrintWriter getAssemblyFile() { return jFile; }
    
	@Override 
	public Integer visitProgram(ClangParser.ProgramContext ctx) 
	{
		String programName = inputFileName;
        
		programId = symTabStack.enterLocal(programName);
		programId.setDefinition(DefinitionImpl.PROGRAM);
		programId.setAttribute(ROUTINE_SYMTAB, symTabStack.push());
		symTabStack.setProgramId(programId);
        
		// Create the assembly output file.
		try {
			jFile = new PrintWriter(new FileWriter(inputFileName + ".j"));
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
        
		// Emit the program header.
		jFile.println(".class public " + programName);
		jFile.println(".super java/lang/Object");
        
		// Emit the RunTimer and PascalTextIn fields.
		jFile.println();
		jFile.println(".field private static _scanner Ljava/util/Scanner;");
		jFile.println(".field private static _runTimer LRunTimer;");
		jFile.println(".field private static _standardIn LPascalTextIn;");
    	
		variableIdList = new ArrayList<SymTabEntry>();

		Integer value = visitChildren(ctx);
    	
		// Emit the class constructor.
		jFile.println();
		jFile.println(".method public <init>()V");
		jFile.println();
		jFile.println("\taload_0");
		jFile.println("\tinvokenonvirtual\tjava/lang/Object/<init>()V");   	
		jFile.println("\treturn");
		jFile.println();
		jFile.println(".limit locals 1");
		jFile.println(".limit stack 1");
		jFile.println(".end method");
		
		// Error Check.
		SymTabEntry variableId;
		variableId = symTabStack.lookupGlobal("main");
		if (variableId == null) {
			System.out.println("'main' Function Not Declared");
			error = true;
			return null;
		}
    	
		Pass2Visitor pass2 = new Pass2Visitor(symTabStack, variableIdList, jFile, inputFileName);
		ParseTree tree = ctx;
		pass2.visit(tree);
		jFile.flush();
		jFile.close();
		
		// Print the cross-reference table.
		CrossReferencer crossReferencer = new CrossReferencer();
		crossReferencer.print(symTabStack);
		
		// Remove the output file if errors occur.
		if (pass2.getError() || error) {
			File file = new File(inputFileName + ".j");
			file.delete();
		}
		
		symTabStack.pop();
    	
		return value;
	}
    
	@Override
	public Integer visitGlobal_var_decl(ClangParser.Global_var_declContext ctx)
	{
		global = true;
		jFile.println("\n; " + ctx.getText() + "\n");
		
		int lineNumber = ctx.getStart().getLine();
		Integer value = null;
		int countVars = ctx.global_var_list().identifier().size();
		for (int i = 0; i < countVars; i++) {
    		
			String variableName = ctx.global_var_list().identifier(i).ID().getText();
			
			SymTabEntry variableId = symTabStack.lookupGlobal(variableName);
			
			// Error check.
			if (variableId != null) {
				System.out.println("Line " + lineNumber + "\tDuplicate Variable: " + variableName);
				error = true;
				return null;
			}
			
			variableId = symTabStack.enterLocal(variableName);
			variableId.setDefinition(VARIABLE);
			variableIdList.add(variableId);
			
			String typeName = ctx.type().getText();
			TypeSpec typeSpec;
			String typeIndicator;
			
			// If the number of subscripts is 0, it's a scalar, otherwise it's an array.
			int dimension = ctx.global_var_list().identifier(i).expr().size();
			if (dimension == 0) {
				// Scalar.
				if (typeName.equals("int")) {
					typeSpec = Predefined.integerType;
					typeIndicator = "I";
					
				} else if (typeName.equals("double")) {
					typeSpec = Predefined.realType;
					typeIndicator = "F";
        		
				} else if (typeName.equals("string")) {
					typeSpec = Predefined.stringType;
					typeIndicator = "Ljava/lang/String;";
	    			
				} else {
					typeSpec = null;
					typeIndicator = "?";
				}
			} else {
				// Array.
				String arrayNotation = "";
				ArrayList<Integer> subscripts = new ArrayList<Integer>();
				for (int j = 0; j < dimension; j++) {
					arrayNotation += "[";
					String subscriptStr = ctx.global_var_list().identifier(i).expr(j).getText();
					Integer subscript = Integer.valueOf(subscriptStr);
					subscripts.add(subscript);
				}
	    		
				variableId.setAttribute(SUBSCRIPTS, subscripts);
				variableId.setAttribute(DIMENSION, dimension);
	    		
				if (typeName.equals("int")) {
					typeSpec = Predefined.integerType;
					typeIndicator = arrayNotation + "I";
					
				} else if (typeName.equals("double")) {
					typeSpec = Predefined.realType;
					typeIndicator = arrayNotation + "F";
        		
				} else if (typeName.equals("string")) {
					typeSpec = Predefined.stringType;
					typeIndicator = arrayNotation + "Ljava/lang/String;";
	    			
				} else {
					typeSpec = null;
					typeIndicator = "?";
				}
			}
        	
			variableId.setTypeSpec(typeSpec);
            
			// Emit a field declaration.
			jFile.println(".field private static " +
					variableId.getName() + " " + typeIndicator);
		}
		global = false;
		return value;
	}

	@Override
	public Integer visitMain_func(ClangParser.Main_funcContext ctx)
	{
		int lineNumber = ctx.getStart().getLine();
		SymTabEntry variableId;
		variableId = symTabStack.lookupGlobal("main");
		
		// Error check.
		if (variableId != null) {
			System.out.println("Line " + lineNumber + "\tDuplicate Function: main");
			error = true;
			return null;
		}
		
		variableId = symTabStack.enterLocal("main");
		variableId.setDefinition(FUNCTION);
		String typeName = ctx.type().getText();
		TypeSpec typeSpec =
        		(typeName.equals("int"))		? Predefined.integerType :
        		(typeName.equals("void"))	? Predefined.voidType :
        		null;
		
		variableId.setTypeSpec(typeSpec);
		return visitChildren(ctx);
	}
	@Override
	public Integer visitFunc(ClangParser.FuncContext ctx)
	{
		int lineNumber = ctx.getStart().getLine();
		String funcName = ctx.ID().getText();
		SymTabEntry variableId;
		variableId = symTabStack.lookupGlobal(funcName);
		
		// Error Check.
		if (variableId != null) {
			System.out.println("Line " + lineNumber + "\tDuplicate Function: " + funcName);
			error = true;
			return null;
		}
		
		variableId = symTabStack.enterLocal(funcName);
		variableId.setDefinition(FUNCTION);
		String typeName = ctx.type().getText();
		TypeSpec typeSpec =
        		(typeName.equals("int"))		? Predefined.integerType :
        		(typeName.equals("double"))	? Predefined.realType :
        		(typeName.equals("string"))	? Predefined.stringType :
        		(typeName.equals("void"))	? Predefined.voidType :
        		null;
		
		variableId.setTypeSpec(typeSpec);
		return visitChildren(ctx);
	}
	
	@Override 
	public Integer visitAddSub(ClangParser.AddSubContext ctx)
	{
		if (!global) {
			return null;
		}
		int lineNumber = ctx.getStart().getLine();
		Integer value = visitChildren(ctx);
        
		TypeSpec leftType = ctx.expr(0).typeSpec;
		TypeSpec rightType = ctx.expr(1).typeSpec;
        
		boolean integerMode =
				(leftType == Predefined.integerType) &&
				(rightType == Predefined.integerType);
		boolean realMode =
				(leftType == Predefined.realType) &&
				(rightType == Predefined.realType);
        
		TypeSpec typeSpec =
				integerMode ? Predefined.integerType :
				realMode    ? Predefined.realType :
				null;
		
		// Error Check.
		if (typeSpec == null) {
			System.out.println("Line " + lineNumber + "\tOperand Type Incompatible");
			error = true;
			return null;
		}

		ctx.typeSpec = typeSpec;
        
		return value; 
	}

	@Override 
	public Integer visitMulDivMod(ClangParser.MulDivModContext ctx)
	{
		if (!global) {
			return null;
		}
		int lineNumber = ctx.getStart().getLine();
		Integer value = visitChildren(ctx);
        
		TypeSpec leftType = ctx.expr(0).typeSpec;
		TypeSpec rightType = ctx.expr(1).typeSpec;
        
		boolean integerMode =
				(leftType == Predefined.integerType) &&
				(rightType == Predefined.integerType);
		boolean realMode =
				(leftType == Predefined.realType) &&
				(rightType == Predefined.realType);
        
		TypeSpec typeSpec =
				integerMode ? Predefined.integerType :
				realMode    ? Predefined.realType :
				null;
        
		// Error Check.
		if (typeSpec == null) {
			System.out.println("Line " + lineNumber + "\tOperand Type Incompatible");
			error = true;
			return null;
		}
		
		ctx.typeSpec = typeSpec;
        
		return value; 
	}
    
	@Override 
	public Integer visitId(ClangParser.IdContext ctx)
	{
		String variableName = ctx.identifier().ID().getText();
		SymTabEntry variableId = symTabStack.lookupLocal(variableName);
        
		// If variable is not in symbol table, it could be local variable.
		if (variableId != null) {
			ctx.typeSpec = variableId.getTypeSpec();
		}
		return visitChildren(ctx); 
	}

	@Override 
	public Integer visitIntNum(ClangParser.IntNumContext ctx)
	{
		ctx.typeSpec = Predefined.integerType;
		return visitChildren(ctx);
	}

	@Override 
	public Integer visitDoubleNum(ClangParser.DoubleNumContext ctx)
	{
		if (!global) {
			return null;
		}
		ctx.typeSpec = Predefined.realType;
		return visitChildren(ctx);
	}
	@Override public Integer visitStrValue(ClangParser.StrValueContext ctx)
	{
		if (!global) {
			return null;
		}
		ctx.typeSpec = Predefined.stringType;
		return visitChildren(ctx);
	}
    
	@Override 
	public Integer visitParens(ClangParser.ParensContext ctx)
	{
		if (!global) {
			return null;
		}
		Integer value = visitChildren(ctx); 
		ctx.typeSpec = ctx.expr().typeSpec;
		return value;
	}
}