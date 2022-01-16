package lu.ewen.minijvm.language.psi;

import com.intellij.psi.tree.IElementType;
import lu.ewen.minijvm.language.MiniJvmLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class MiniJvmTokenType extends IElementType {

  public MiniJvmTokenType(@NotNull @NonNls String debugName) {
    super(debugName, MiniJvmLanguage.INSTANCE);
  }

  @Override
  public String toString() {
    return "MiniJvmTokenType." + super.toString();
  }

}
