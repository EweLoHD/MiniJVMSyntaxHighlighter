// This is a generated file. Not intended for manual editing.
package lu.ewen.minijvm.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static lu.ewen.minijvm.language.psi.MiniJvmTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import lu.ewen.minijvm.language.psi.*;

public class MiniJvmAlsoImpl extends ASTWrapperPsiElement implements MiniJvmAlso {

  public MiniJvmAlsoImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MiniJvmVisitor visitor) {
    visitor.visitAlso(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MiniJvmVisitor) accept((MiniJvmVisitor)visitor);
    else super.accept(visitor);
  }

}
