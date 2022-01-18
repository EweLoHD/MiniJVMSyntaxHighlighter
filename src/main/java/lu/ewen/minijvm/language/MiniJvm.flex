package lu.ewen.minijvm.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import lu.ewen.minijvm.language.psi.MiniJvmTypes;
import com.intellij.psi.TokenType;

import static com.intellij.psi.TokenType.*;
import static lu.ewen.minijvm.language.psi.MiniJvmTypes.*;

%%
%ignorecase
%class MiniJvmLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}


EOL_WS = \n | \r | \r\n
LINE_WS = [\ \t]

COMMENT = {LINE_WS}*("//")[^\r\n]*
LABEL = ([a-zA-Z0-9$._~?#@]+):

EXPRESSION = (ADD|ALLOC|AND|CONST|DIV|EQ|FALSE|FJUMP|HALT|JUMP|JUMPF|LE|LEQ|LESS|LOAD|MOD|MUL|NEG|NEQ|NOT|OR|READ|STORE|SUB|TRUE|WRITE)

PARAM_DECIMAL = [0-9]+
PARAM_LABEL = [a-zA-Z0-9$._~?#@]+

CRLF=\R

INVALID_KEYWORD=[a-zA-Z0-9]+

%%

<YYINITIAL> {
    {EOL_WS}+                  {return EOL_WS;}
    {LINE_WS}+                 {return LINE_WS;}
    {COMMENT}                  {return COMMENT;}
    {LABEL}                    {return LABEL;}
    {EXPRESSION}               {return EXPRESSION;}
    {PARAM_DECIMAL}            {return PARAM_DECIMAL;}
    {PARAM_LABEL}              {return PARAM_LABEL;}

    // otherwise some keywords are highlighted as bad chars after completing the keyword
    // https://intellij-support.jetbrains.com/hc/en-us/community/posts/360010554180--Custom-Language-Plugin-Highlighting-not-working-despite-correctly-parsed-psi-file
    {INVALID_KEYWORD}          { yybegin(YYINITIAL); return BAD_CHARACTER; }
}

[^] { yybegin(YYINITIAL); return BAD_CHARACTER; }
