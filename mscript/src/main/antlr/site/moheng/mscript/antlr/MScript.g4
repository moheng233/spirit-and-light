grammar MScript;

@header {
package site.moheng.mscript.antlr;
}

AND : 'and' ;
OR : 'or' ;
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

VAR : 'var';
CONST : 'const';
RETURN : 'return';

VOID : 'void';
TYPE_INT : 'int' ;
TYPE_BOOL : 'bool' ;
TYPE_FLOAT : 'float' ;

TRUE : 'true';
FALSE : 'false';
fragment DIGIT : [0-9] ;
INT : DIGIT+ ;
FLOAT : DIGIT DOT DIGIT ;
STRING: '"' (.)*? '"' ;
ID: [a-zA-Z_][a-zA-Z_0-9]*;
WS: [ \t\n\r\f]+ -> skip ;

program : (varDefStat | closureStat)* EOF ;

varDefStat : count=CONST? (type=typeExpr|VAR) name=ID ASSIGN value=expr SEMI ;
closureStat : returnValue=typeExpr name=ID args=argDef body=bodyStat ;
returnStat : RETURN value=expr SEMI ;
exprStat : expr SEMI;
bodyStat: '{' stats+=stat* '}' ;

closureExpr: returnValue=typeExpr args=argDef '=>' body=bodyStat ;

stat
    : varDefStat
    | closureStat
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
    | typeClosureLiteral
    | ID
    ;

typeExpr
    : typeExpr DOT typeLiteral
    | typeExpr '<' args+=typeExpr (COMMA args+=typeExpr )* '>'
    | typeLiteral
    ;

literal
    : value=ID
    | value=INT
    | value=FLOAT
    | value=(TRUE | FALSE)
    | value=STRING
    ;

expr: NOT expr
    | '(' expr ')'
    | expr (AND | OR) expr
    | expr (TIMES | DIVIDE) expr
    | expr (PLUS | LESS) expr
    | expr (EQ | NE) expr
    | expr (LT | LE | GE | GT) expr
    | ID ASSIGN expr
    | closureExpr
    | call
    | literal
    ;

call : ID '(' expr (COMMA expr)* ')' ;