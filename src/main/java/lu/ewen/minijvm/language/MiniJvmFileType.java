// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package lu.ewen.minijvm.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.intellij.sdk.language.SimpleIcons;
import org.intellij.sdk.language.SimpleLanguage;
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
