// This is a generated file. Not intended for manual editing.
package lu.ewen.minijvm.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import lu.ewen.minijvm.language.psi.impl.*;

public interface MiniJvmTypes {

  IElementType INS = new MiniJvmElementType("INS");

  IElementType COMMENT = new MiniJvmTokenType("COMMENT");
  IElementType CRLF = new MiniJvmTokenType("CRLF");
  IElementType INSTRUCTION = new MiniJvmTokenType("INSTRUCTION");
  IElementType LABEL = new MiniJvmTokenType("LABEL");
  IElementType PARAM_DECIMAL = new MiniJvmTokenType("PARAM_DECIMAL");
  IElementType PARAM_LABEL = new MiniJvmTokenType("PARAM_LABEL");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == INS) {
        return new MiniJvmInsImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
