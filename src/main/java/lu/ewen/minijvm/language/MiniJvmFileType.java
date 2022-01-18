package lu.ewen.minijvm.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class MiniJvmFileType extends LanguageFileType {

  public static final MiniJvmFileType INSTANCE = new MiniJvmFileType();

  private MiniJvmFileType() {
    super(MiniJvmLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public String getName() {
    return "MiniJVM File";
  }

  @NotNull
  @Override
  public String getDescription() {
    return "MiniJVM language file";
  }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return "jvm";
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return MiniJvmIcons.FILE;
  }

}
