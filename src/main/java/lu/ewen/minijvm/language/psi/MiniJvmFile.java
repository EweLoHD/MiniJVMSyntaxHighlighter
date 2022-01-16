// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package lu.ewen.minijvm.language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import lu.ewen.minijvm.language.MiniJvmFileType;
import lu.ewen.minijvm.language.MiniJvmLanguage;
import org.jetbrains.annotations.NotNull;

public class MiniJvmFile extends PsiFileBase {

  public MiniJvmFile(@NotNull FileViewProvider viewProvider) {
    super(viewProvider, MiniJvmLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return MiniJvmFileType.INSTANCE;
  }

  @Override
  public String toString() {
    return "MiniJVM File";
  }

}
