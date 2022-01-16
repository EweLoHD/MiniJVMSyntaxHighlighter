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
  // (INSTRUCTION PARAM_DECIMAL) | (INSTRUCTION PARAM_LABEL) | INSTRUCTION
  public static boolean ins(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ins")) return false;
    if (!nextTokenIs(b, INSTRUCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ins_0(b, l + 1);
    if (!r) r = ins_1(b, l + 1);
    if (!r) r = consumeToken(b, INSTRUCTION);
    exit_section_(b, m, INS, r);
    return r;
  }

  // INSTRUCTION PARAM_DECIMAL
  private static boolean ins_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ins_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, INSTRUCTION, PARAM_DECIMAL);
    exit_section_(b, m, null, r);
    return r;
  }

  // INSTRUCTION PARAM_LABEL
  private static boolean ins_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ins_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, INSTRUCTION, PARAM_LABEL);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COMMENT|LABEL|ins|CRLF
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, LABEL);
    if (!r) r = ins(b, l + 1);
    if (!r) r = consumeToken(b, CRLF);
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
