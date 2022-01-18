// This is a generated file. Not intended for manual editing.
package lu.ewen.minijvm.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import lu.ewen.minijvm.language.psi.impl.*;

public interface MiniJvmTypes {

  IElementType ALSO = new MiniJvmElementType("ALSO");

  IElementType COMMENT = new MiniJvmTokenType("COMMENT");
  IElementType EOL_WS = new MiniJvmTokenType("EOL_WS");
  IElementType EXPRESSION = new MiniJvmTokenType("EXPRESSION");
  IElementType LABEL = new MiniJvmTokenType("LABEL");
  IElementType LINE_WS = new MiniJvmTokenType("LINE_WS");
  IElementType PARAM_DECIMAL = new MiniJvmTokenType("PARAM_DECIMAL");
  IElementType PARAM_LABEL = new MiniJvmTokenType("PARAM_LABEL");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ALSO) {
        return new MiniJvmAlsoImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
