package analizadorlexico;

%%

%function nextToken

%public

%class Lexer

%unicode

%{
	
    Cadena cadena;
	
    int c;
	
%}

%type Cadena

%init{

    cadena = null;
	
    c = 0;
	
%init}

%eof{
%eof}

%line

%column

DIGITO = [0-9]

LETRA = [A-Za-z]

ESPACIO = [\n\t\r ]

IDENTIFICADOR = {LETRA}({LETRA}|{DIGITO})*

ENTERO = {DIGITO}+

FLOTANTE = {ENTERO}"."{ENTERO}

%%

"+" {

    c ++;

    cadena = new Cadena(c, "Suma", yytext(), yyline, yycolumn);

    return cadena;

}

"-" {

    c ++;

    cadena = new Cadena(c, "Resta", yytext(), yyline, yycolumn);

    return cadena;

}

"*" {

    c ++;

    cadena = new Cadena(c, "Multiplicación", yytext(), yyline, yycolumn);

    return cadena;

}

"/" {

    c ++;

    cadena = new Cadena(c, "División", yytext(), yyline, yycolumn);

    return cadena;

}

"=" {

    c ++;

    cadena = new Cadena(c, "Asignación", yytext(), yyline, yycolumn);

    return cadena;

}


"(" {

    c ++;

    cadena = new Cadena(c, "Paréntesis izquierdo", yytext(), yyline, yycolumn);

    return cadena;

}

")" {

    c ++;

    cadena = new Cadena(c, "Paréntesis derecho", yytext(), yyline, yycolumn);

    return cadena;

}

";" {

    c ++;

    cadena = new Cadena(c, "Fin de instrucción", yytext(), yyline, yycolumn);

    return cadena;

}

"int" {

    c ++;

    cadena = new Cadena(c, "Declaración de entero", yytext(), yyline, yycolumn);

    return cadena;

}

"float" {

    c ++;

    cadena = new Cadena(c, "Declaración de flotante", yytext(), yyline, yycolumn);

    return cadena;

}

{ENTERO} {

    c ++;

    cadena = new Cadena(c, "Entero", yytext(), yyline, yycolumn);

    return cadena;
    
}

{FLOTANTE} {

    c ++;

    cadena = new Cadena(c, "Flotante", yytext(), yyline, yycolumn);

    return cadena;

}

{IDENTIFICADOR} {

    c ++;

    cadena = new Cadena(c, "Identificador", yytext(), yyline, yycolumn);

    return cadena;

}

{ESPACIO} {}

. {

    c ++;

    cadena = new Cadena(c, "No válido", yytext(), yyline, yycolumn);

    return cadena;

}