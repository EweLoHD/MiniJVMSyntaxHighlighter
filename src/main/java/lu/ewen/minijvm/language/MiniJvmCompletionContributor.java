package lu.ewen.minijvm.language;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import lu.ewen.minijvm.language.psi.MiniJvmTypes;
import org.jetbrains.annotations.NotNull;

public class MiniJvmCompletionContributor extends CompletionContributor {

    public MiniJvmCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(),
                new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("ADD"));
                        resultSet.addElement(LookupElementBuilder.create("ALLOC"));
                        resultSet.addElement(LookupElementBuilder.create("AND"));
                        resultSet.addElement(LookupElementBuilder.create("CONST"));
                        resultSet.addElement(LookupElementBuilder.create("DIV"));
                        resultSet.addElement(LookupElementBuilder.create("EQ"));
                        resultSet.addElement(LookupElementBuilder.create("FALSE"));
                        resultSet.addElement(LookupElementBuilder.create("FJUMP"));
                        resultSet.addElement(LookupElementBuilder.create("HALT"));
                        resultSet.addElement(LookupElementBuilder.create("JUMP"));
                        resultSet.addElement(LookupElementBuilder.create("JUMPF"));
                        resultSet.addElement(LookupElementBuilder.create("LE"));
                        resultSet.addElement(LookupElementBuilder.create("LEQ"));
                        resultSet.addElement(LookupElementBuilder.create("LESS"));
                        resultSet.addElement(LookupElementBuilder.create("LOAD"));
                        resultSet.addElement(LookupElementBuilder.create("MOD"));
                        resultSet.addElement(LookupElementBuilder.create("MUL"));
                        resultSet.addElement(LookupElementBuilder.create("NEG"));
                        resultSet.addElement(LookupElementBuilder.create("NEQ"));
                        resultSet.addElement(LookupElementBuilder.create("NOT"));
                        resultSet.addElement(LookupElementBuilder.create("OR"));
                        resultSet.addElement(LookupElementBuilder.create("READ"));
                        resultSet.addElement(LookupElementBuilder.create("STORE"));
                        resultSet.addElement(LookupElementBuilder.create("SUB"));
                        resultSet.addElement(LookupElementBuilder.create("TRUE"));
                        resultSet.addElement(LookupElementBuilder.create("WRITE"));
                    }
                }
        );
    }
}
