package lu.ewen.minijvm.language;

import com.intellij.lexer.FlexAdapter;

public class MiniJvmLexerAdapter extends FlexAdapter {

  public MiniJvmLexerAdapter() {
    super(new MiniJvmLexer(null));
  }

}
