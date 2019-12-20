grammar Clang;

@header {
    import wci.intermediate.TypeSpec;
}
//Program is composed of any number of user-defined functions
//followed by only one main function
program :
	(global_var_decl | func)*
	main_func
	(global_var_decl | func)*;

//Skip all white spaces
NEWLINE : '\r'? '\n' -> skip;
BLANK : ' ' -> skip;
TAB : '\t' -> skip;

//Name of main function
MAIN : 'main';

//Assignment operator
ASSIGN : '=';

//Relational operators
EQ : '==';
NOT_EQ : '!=';
LE : '<';
LE_EQ : '<=';
GT : '>';
GT_EQ : '>=';

//Arithmetic operators
ADD : '+';
SUB : '-';
MUL : '*';
DIV : '/';
MOD : '%';
INC_DEC : '++'|'--';

//Logical operators
OR : '||';
AND : '&&';
NOT : '!';

//Types
VOID : 'void';
INT : 'int';
DOUBLE : 'double';
STRING : 'string';
type
	: VOID
	| INT
	| DOUBLE
	| STRING
	;

//Reserved words
IF : 'if';
ELSE : 'else';
WHILE : 'while';
FOR : 'for';
RETURN : 'return';
BREAK : 'break';

//Variable and numbers
ID : [a-zA-Z_][a-zA-Z0-9_]*;
INT_NUM : [0-9]+;
DOUBLE_NUM : [0-9]+ ('.') [0-9]+;
STR_VALUE : '"' ~["]* '"';

//Parse identifier.
identifier	: ID ('[' expr ']')*;

//Parse variable declarations
global_var_decl : type global_var_list ';';
global_var_list : identifier (ASSIGN expr)? (',' identifier (ASSIGN expr)?)*;
local_var_decl : type local_var_list ';';
local_var_list : identifier (ASSIGN expr)? (',' identifier (ASSIGN expr)?)*;

//Parse statements
stmt
	: assign_stmt ';'
	| nonassign_stmt ';'
	| block
	| if_stmt
	| while_stmt
	| for_stmt
	| rtn_stmt ';'
	| break_stmt ';'
	| inc_dec_stmt ';'
	;

assign_stmt : identifier ASSIGN expr;
nonassign_stmt : expr;
block : '{' (local_var_decl | stmt)* '}';
if_stmt : IF '(' expr ')' block (ELSE block)?;
while_stmt : WHILE '(' expr ')'  block;
for_init : local_var_decl|assign_stmt ';';
for_end : assign_stmt|inc_dec_stmt; 
for_stmt : FOR '(' for_init expr';' for_end ')' block;
rtn_stmt : RETURN (expr | );
break_stmt : BREAK;
inc_dec_stmt : (identifier INC_DEC | INC_DEC identifier);

//Parse expression according to C language operator precedence
expr locals [ TypeSpec typeSpec = null ]
	: identifier 							#Id
	| INT_NUM								#IntNum
	| DOUBLE_NUM							#DoubleNum
	| STR_VALUE							#StrValue
	| NOT expr								#Not
	| '(' expr ')'						#Parens
	| func_call							#FuncCall
	| sign=(ADD|SUB) expr				#SignedExpr
	| expr mulDivModOp=(MUL|DIV|MOD)	expr	#MulDivMod
	| expr addSubOp=(ADD|SUB)			expr	#AddSub
	| expr relOp=(LE|LE_EQ|GT|GT_EQ)	expr	#Relativity
	| expr eqOp=(EQ|NOT_EQ) 				expr	#Equality
	| expr AND expr						#And
	| expr OR expr						#Or
	;

//Actual arguments
actual_arg_list : (expr (',' expr)*) | ;

//Parse function calls
func_call: ID '(' actual_arg_list ')';

//Formal parameters
BRAKETS : '[' ']';
argument : ID (BRAKETS)*;
formal_args
	: (type argument (',' type argument)* )
	| VOID
	| ;
formal_args_proto
	: (type argument? (',' type argument?)* )
	| VOID
	| ;


//Parse user-defined function
func : type ID '(' formal_args ')' block;

//Parse main function
main_func: type MAIN '(' ')' block;
