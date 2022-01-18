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

COMMENT = "//"[^\r\n]*
LABEL = ([a-zA-Z0-9$._~?#@]+):

EXPRESSION = (ADD|ALLOC|AND|CONST|DIV|EQ|FALSE|FJUMP|HALT|JUMP|JUMPF|LE|LEQ|LESS|LOAD|MOD|MUL|NEG|NEQ|NOT|OR|READ|STORE|SUB|TRUE|WRITE)

CRLF=\R

%%

<YYINITIAL> {
    {EOL_WS}+                  {return EOL_WS;}
    {LINE_WS}+                 {return LINE_WS;}
    {COMMENT}                  {return COMMENT;}
    {LABEL}                    {return LABEL;}
    {EXPRESSION}               {return EXPRESSION;}
}

[^]                            { return BAD_CHARACTER; }
