package lu.ewen.minijvm.language;

import com.intellij.lang.Language;

public class MiniJvmLanguage extends Language {

  public static final MiniJvmLanguage INSTANCE = new MiniJvmLanguage();

  private MiniJvmLanguage() {
    super("MiniJVM");
  }

}
