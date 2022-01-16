// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package lu.ewen.minijvm.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import lu.ewen.minijvm.language.psi.MiniJvmTypes;
import com.intellij.psi.TokenType;

%%

%class MiniJvmLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]

//FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
//VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT="//"[^\r\n]*
LABEL=([a-zA-Z0-9$._~?#@]+):
INSTRUCTION=(ADD|add|ALLOC|alloc|AND|and|CONST|const|DIV|div|EQ|eq|FALSE|false|FJUMP|fjump|HALT|halt|JUMP|jump|JUMPF|jumpf|LE|le|LEQ|leq|LESS|less|LOAD|load|MOD|mod|MUL|mul|NEG|neg|NEQ|neq|NOT|not|OR|or|READ|read|STORE|store|SUB|sub|TRUE|true|WRITE|write)
PARAM_DECIMAL=[ ][0-9]+
PARAM_LABEL=[ ][a-zA-Z0-9$._~?#@]+
SEPARATOR=[\ \t\f]
//KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "

%state WAITING_VALUE

%%

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return MiniJvmTypes.COMMENT; }

//<YYINITIAL> {KEY_CHARACTER}+                                { yybegin(YYINITIAL); return MiniJvmTypes.KEY; }

<YYINITIAL> {LABEL}                                         { yybegin(YYINITIAL); return MiniJvmTypes.LABEL; }

<YYINITIAL> {INSTRUCTION}                                   { yybegin(YYINITIAL); return MiniJvmTypes.INSTRUCTION; }

<YYINITIAL> {PARAM_DECIMAL}                                 { yybegin(YYINITIAL); return MiniJvmTypes.PARAM_DECIMAL; }

<YYINITIAL> {PARAM_LABEL}                                 { yybegin(YYINITIAL); return MiniJvmTypes.PARAM_LABEL; }

//<YYINITIAL> {SEPARATOR}                                     { yybegin(WAITING_VALUE); return MiniJvmTypes.SEPARATOR; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

//<WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}*   { yybegin(YYINITIAL); return MiniJvmTypes.VALUE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^]                                                         { return TokenType.BAD_CHARACTER; }
