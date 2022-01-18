package lu.ewen.minijvm.language;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import lu.ewen.minijvm.language.psi.MiniJvmTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class MiniJvmSyntaxHighlighter extends SyntaxHighlighterBase {

  public static final TextAttributesKey EXPRESSION =
          createTextAttributesKey("MINIJVM_EXPRESSION", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey PARAM_DECIMAL =
          createTextAttributesKey("MINIJVM_PARAM_DECIMAL", DefaultLanguageHighlighterColors.NUMBER);
  public static final TextAttributesKey PARAM_LABEL =
          createTextAttributesKey("MINIJVM_PARAM_LABEL", DefaultLanguageHighlighterColors.INSTANCE_FIELD);
  public static final TextAttributesKey LABEL =
          createTextAttributesKey("MINIJVM_LABEL", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
  public static final TextAttributesKey COMMENT =
          createTextAttributesKey("MINIJVM_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
  public static final TextAttributesKey BAD_CHARACTER =
          createTextAttributesKey("MINIJVM_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

  
  private static final TextAttributesKey[] EXPRESSION_KEYS = new TextAttributesKey[]{EXPRESSION};
  private static final TextAttributesKey[] PARAM_DECIMAL_KEYS = new TextAttributesKey[]{PARAM_DECIMAL};
  private static final TextAttributesKey[] PARAM_LABEL_KEYS = new TextAttributesKey[]{PARAM_LABEL};
  private static final TextAttributesKey[] LABEL_KEYS = new TextAttributesKey[]{LABEL};
  private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
  private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
  private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

  @NotNull
  @Override
  public Lexer getHighlightingLexer() {
    return new MiniJvmLexerAdapter();
  }

  @Override
  public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
    if (tokenType.equals(MiniJvmTypes.EXPRESSION)) {
      return EXPRESSION_KEYS;
    }
    if (tokenType.equals(MiniJvmTypes.PARAM_DECIMAL)) {
      return PARAM_DECIMAL_KEYS;
    }
    if (tokenType.equals(MiniJvmTypes.PARAM_LABEL)) {
      return PARAM_LABEL_KEYS;
    }
    if (tokenType.equals(MiniJvmTypes.LABEL)) {
      return LABEL_KEYS;
    }
    if (tokenType.equals(MiniJvmTypes.COMMENT)) {
      return COMMENT_KEYS;
    }
    if (tokenType.equals(TokenType.BAD_CHARACTER)) {
      return BAD_CHAR_KEYS;
    }
    return EMPTY_KEYS;
  }

}
