package analizadorlexico;

%%

%class Lexer

%type Token

LETRA = [a-zA-Z_]

DIGITO = [0-9]

ESPACIO = [ \t\r\n]

%{

public String lexema;

%}

%%

{ESPACIO} {/*Ignore*/}

"=" {return Token.ASIGNACION;}

"==" {return Token.IGUALACION;}

"+" {return Token.SUMA;}

"*" {return Token.MULTIPLICACION;}

"/" {return Token.DIVISION;}

"-" {return Token.RESTA;}

{LETRA}({LETRA}|{DIGITO})* {lexema = yytext(); return Token.IDENTIFICADOR;}

("(-"{DIGITO}+")")|{DIGITO}+ {lexema = yytext(); return Token.ENTERO;}

. {return Token.ERROR;}