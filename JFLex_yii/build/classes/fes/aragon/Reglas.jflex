package fes.aragon;
import static fes.aragon.Tokens.*;
%%
%class Lexico
%type Tokens
L = [a-zA-Z_]
D = [0-9]
WHITE=[ \t\r\n]
%{
public String lexema;
%}
%%
{WHITE} {/*Ignore*/}
"(" {return ParentIzq;}
")" {return ParentDer;}
"true" {return Verdadero;}
"TRUE" {return Verdadero;}
"false" {return Falso;}
"FALSE" {return Falso;}
"not" {return Not;}
"NOT" {return Not;}
"and" {return And;}
"AND" {return And;}
"or" {return Or;}
"OR" {return Or;}
"si" {return SoloSi;}
"SI" {return SoloSi;}
"sii" {return SiYSoloSi;}
"SII" {return SiYSoloSi;}
({L}|{D})* {return Error;}
. {return Error;}
