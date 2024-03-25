grammar MScript;
options {
    contextSuperClass=org.antlr.v4.runtime.RuleContextWithAltNum;
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
STRING: '"' (.)*? '"' ;
ID: [a-zA-Z_][a-zA-Z_0-9]*;
WS: [ \t\n\r\f]+ -> skip ;

program : (varDefStat | closureStat | interfaceDefStat | structDefStat)* EOF ;

interfaceClosureStat : returnValue=typeExpr name=ID args=argDef SEMI ;
interfaceDefStat : INTERFACE name=ID (EXTENDS extends+=ID ( ',' extends+=ID)*)? '{' vars+=interfaceClosureStat* '}';

structDefStat : STRUCT name=ID (EXTENDS extends+=ID ( ',' extends+=ID)*)? '{' (vars+=varDefStat | closures+= closureStat)* '}' ;

variable: ID ('.' ID)*;
varDefStat : count=CONST? (type=typeExpr|VAR) name=ID ASSIGN value=expr SEMI ;
closureStat : returnValue=typeExpr name=ID args=argDef body=bodyStat ;
assignStat : name=variable ASSIGN value=expr SEMI ;
returnStat : RETURN value=expr SEMI ;
bodyStat: '{' stats+=stat* '}' ;
exprStat : expr SEMI;

closureExpr: returnValue=typeExpr args=argDef '=>' body=bodyStat ;

stat
    : varDefStat
    | assignStat
    | returnStat
    | exprStat
    | bodyStat
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
    : typeExpr '<' args+=typeExpr (COMMA args+=typeExpr )* '>'
    | typeLiteral
    ;

literal
    : value=INT
    | value=FLOAT
    | value=(TRUE | FALSE)
    | value=STRING
    ;

expr: oper=NOT right=expr
    | '(' right=expr ')'
    | left=expr (oper=AND | oper=OR) right=expr
    | left=expr (oper=TIMES | oper=DIVIDE) right=expr
    | left=expr (oper=PLUS | oper=LESS) right=expr
    | left=expr (oper=EQ | oper=NE) right=expr
    | left=expr (oper=LT | oper=LE | oper=GE | oper=GT) right=expr
    | closureExpr
    | call
    | literal
    | variable
    ;

call : ID '(' expr (COMMA expr)* ')' ;