grammar script;

FUNCTION : 'function' ;
ON : 'on' ;
EVENT : 'event' ;

AND : 'and' ;
OR : 'or' ;
NOT : 'not' ;
ASSIGN : '=' ;
DOT : '.' ;
PLUS : '+' ;
LESS : '-' ;
TIMES : '*' ;
DIVIDE : '/' ;
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
VOID : 'void';
RETURN : 'return';

TYPE_INT : 'int' ;
TYPE_BOOL : 'bool' ;
TYPE_FLOAT : 'float' ;

TRUE : 'true';
FALSE : 'false';
fragment DIGIT : [0-9] ;
INT : DIGIT+ ;
FLOAT : DIGIT DOT DIGIT ;
ID: [a-zA-Z_][a-zA-Z_0-9]*;
WS: [ \t\n\r\f]+ -> skip ;

program : (stat | event | functionDef | onDef)* EOF ;

varDef: count=CONST? (type=typeExpr|VAR) name=ID ASSIGN value=expr ;

stat: varDef SEMI
    | RETURN expr SEMI
    | expr SEMI
    ;

body: '{' stat* '}' ;

uniArgDef : type=typeExpr id=ID ;
argDef : '(' args+=uniArgDef (COMMA args+=uniArgDef)* ')' ;

functionDef : FUNCTION ID argDef (':' typeExpr) body ;

event : EVENT ID argDef SEMI ;

onDef : ON ID '(' args+=ID (COMMA args+=ID)* ')' body ;

typeExpr: VOID
    | TYPE_INT
    | TYPE_FLOAT
    | TYPE_BOOL
    | ID
    ;

expr: NOT expr
    | expr (AND|OR) expr
    | expr (TIMES|DIVIDE) expr
    | expr (PLUS|LESS) expr
    | expr (EQ | NE) expr
    | expr (LT | LE | GE | GT) expr
    | LPAREN expr RPAREN
    | call
    | ID
    | INT
    | FLOAT
    | (TRUE | FALSE)
    ;

call : ID LPAREN expr (COMMA expr)* RPAREN ;