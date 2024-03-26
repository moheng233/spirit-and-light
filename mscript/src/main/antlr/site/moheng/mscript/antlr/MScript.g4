grammar MScript;
options {
}

@header {
package site.moheng.mscript.antlr;
}

AND : '&&' ;
OR : '||' ;
ASSIGN : '=' ;
DOT : '.' ;
PLUS : '+' ;
LESS : '-' ;
TIMES : '*' ;
DIVIDE : '/' ;
NOT : '!' ;
EQ : '==' ;
NE : '!=' ;
GT : '>' ;
GE : '>=' ;
LT : '<' ;
LE : '<=' ;
COMMA : ',' ;
SEMI : ';' ;
LPAREN : '(' ;
RPAREN : ')' ;
LCURLY : '{' ;
RCURLY : '}' ;

VAR : 'var' ;
CONST : 'const' ;
RETURN : 'return' ;
IF : 'if' ;
FUNCTION: 'function' | 'fun' ;
INTERFACE : 'interface' ;
STRUCT: 'struct' ;
EXTENDS : 'extends' ;

VOID : 'void' ;
TYPE_INT : 'int' ;
TYPE_BOOL : 'bool' ;
TYPE_FLOAT : 'float' ;
TYPE_STRING : 'string' ;

TRUE : 'true' ;
FALSE : 'false' ;
fragment DIGIT : [0-9] ;
INT : DIGIT+ ;
FLOAT : DIGIT DOT DIGIT ;
STRING: '"' .*? '"' ;
ID: [a-zA-Z_][a-zA-Z_0-9]*;

LINE_COMMENT : '//' .*? '\r'? '\n' -> skip ;
COMMENT : '/*' .*? '*/' -> skip ;
WS: [ \t\n\r\f]+ -> skip ;

program
    : (vars+=varDefStat | closures+=closureStat | interfaces+=interfaceDefStat | structs+=structDefStat)* EOF ;

interfaceClosureStat : returnValue=typeExpr name=ID args=argDef SEMI ;
interfaceDefStat : INTERFACE name=ID (EXTENDS extends+=ID ( ',' extends+=ID)*)? '{' vars+=interfaceClosureStat* '}';

structDefStat : STRUCT name=ID (EXTENDS extends+=ID ( ',' extends+=ID)*)? '{' (vars+=varDefStat | closures+= closureStat)* '}' ;

variable: id+=ID ('.' id+=ID)*;
varDefStat : count=CONST? (type=typeExpr|VAR) name=ID ASSIGN value=expr SEMI ;
closureStat : FUNCTION name=ID args=argDef ( ':' returnValue=typeExpr )? body=bodyStat ;
bodyStat: '{' stats+=stat* '}' ;

stat
    : varDefStat #VariableDefineStatement
    | name=variable ASSIGN value=expr SEMI #VariableAssignStatement
    | IF '(' conditions=expr ')' bodyStat #IFStatement
    | RETURN value=expr SEMI #ReturnStatement
    | value=expr SEMI #ExpressionStatement
    | bodyStat #BodyStatement
    ;



uniArgDef : type=typeExpr name=ID ;
argDef : '(' (args+=uniArgDef (COMMA args+=uniArgDef)*)? ')' ;

typeUniArgDef : type=typeExpr name=ID? ;
typeArgDef : '(' (args+=typeUniArgDef (COMMA args+=typeUniArgDef)*)? ')' ;

typeClosureLiteral : typeArgDef '=>' typeExpr ;

typeLiteral
    : VOID
    | TYPE_INT
    | TYPE_FLOAT
    | TYPE_BOOL
    | TYPE_STRING
    | typeClosureLiteral
    | ID
    ;

typeExpr
    : typeLiteral #TypeLiteralExpression
    | typeExpr '<' args+=typeExpr (COMMA args+=typeExpr )* '>' #TypeGenericsExpression
    ;

literal
    : value=INT #IntLiteral
    | value=FLOAT #FloatLiteral
    | value=(TRUE | FALSE) #BooleanLiteral
    | value=STRING #StringLiteral
    ;

expr: left=expr '(' args+=expr (COMMA args+=expr)* ')' #CallExpression
    | oper=NOT right=expr #NotExpression
    | left=expr (oper=AND | oper=OR) right=expr #CombinatorialLogicExpression
    | left=expr (oper=EQ | oper=NE | oper=LT | oper=LE | oper=GE | oper=GT) right=expr #ComparativeLogicExpression
    | left=expr (oper=TIMES | oper=DIVIDE | oper=PLUS | oper=LESS) right=expr #MathsExpression
    | returnValue=typeExpr args=argDef '=>' body=bodyStat #ClosureExpression
    | variable #VariableExpression
    | literal #LiteralExpression
    | '(' right=expr ')' #ParenExpression
    ;