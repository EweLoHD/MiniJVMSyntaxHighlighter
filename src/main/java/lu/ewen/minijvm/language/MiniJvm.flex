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
END_OF_LINE_COMMENT="//"[^\r\n]*
LABEL=([a-zA-Z0-9$._~?#@]+):
INSTRUCTION=(ADD|add|ALLOC|alloc|AND|and|CONST|const|DIV|div|EQ|eq|FALSE|false|FJUMP|fjump|HALT|halt|JUMP|jump|JUMPF|jumpf|LE|le|LEQ|leq|LESS|less|LOAD|load|MOD|mod|MUL|mul|NEG|neg|NEQ|neq|NOT|not|OR|or|READ|read|STORE|store|SUB|sub|TRUE|true|WRITE|write)
PARAM_DECIMAL=[ ][0-9]+
PARAM_LABEL=[ ][a-zA-Z0-9$._~?#@]+

%state WAITING_VALUE

%%

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return MiniJvmTypes.COMMENT; }

<YYINITIAL> {LABEL}                                         { yybegin(YYINITIAL); return MiniJvmTypes.LABEL; }

<YYINITIAL> {INSTRUCTION}                                   { yybegin(YYINITIAL); return MiniJvmTypes.INSTRUCTION; }

<YYINITIAL> {PARAM_DECIMAL}                                 { yybegin(YYINITIAL); return MiniJvmTypes.PARAM_DECIMAL; }

<YYINITIAL> {PARAM_LABEL}                                   { yybegin(YYINITIAL); return MiniJvmTypes.PARAM_LABEL; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^]                                                         { return TokenType.BAD_CHARACTER; }
