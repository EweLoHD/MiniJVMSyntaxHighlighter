// This is a generated file. Not intended for manual editing.
package lu.ewen.minijvm.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static lu.ewen.minijvm.language.psi.MiniJvmTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class MiniJvmParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return miniJvmFile(b, l + 1);
  }

  /* ********************************************************** */
  // LINE_WS|EOL_WS
  public static boolean also(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "also")) return false;
    if (!nextTokenIs(b, "<also>", EOL_WS, LINE_WS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ALSO, "<also>");
    r = consumeToken(b, LINE_WS);
    if (!r) r = consumeToken(b, EOL_WS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LABEL|(EXPRESSION (LINE_WS (PARAM_DECIMAL|PARAM_LABEL))?)|COMMENT|EOL_WS
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LABEL);
    if (!r) r = item__1(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, EOL_WS);
    exit_section_(b, m, null, r);
    return r;
  }

  // EXPRESSION (LINE_WS (PARAM_DECIMAL|PARAM_LABEL))?
  private static boolean item__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXPRESSION);
    r = r && item__1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LINE_WS (PARAM_DECIMAL|PARAM_LABEL))?
  private static boolean item__1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__1_1")) return false;
    item__1_1_0(b, l + 1);
    return true;
  }

  // LINE_WS (PARAM_DECIMAL|PARAM_LABEL)
  private static boolean item__1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LINE_WS);
    r = r && item__1_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PARAM_DECIMAL|PARAM_LABEL
  private static boolean item__1_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__1_1_0_1")) return false;
    boolean r;
    r = consumeToken(b, PARAM_DECIMAL);
    if (!r) r = consumeToken(b, PARAM_LABEL);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean miniJvmFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "miniJvmFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "miniJvmFile", c)) break;
    }
    return true;
  }

}
