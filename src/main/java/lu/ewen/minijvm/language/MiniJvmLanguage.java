// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package lu.ewen.minijvm.language;

import com.intellij.lang.Language;

public class MiniJvmLanguage extends Language {

  public static final MiniJvmLanguage INSTANCE = new MiniJvmLanguage();

  private MiniJvmLanguage() {
    super("MiniJVM");
  }

}
