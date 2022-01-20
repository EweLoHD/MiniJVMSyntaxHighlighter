package lu.ewen.minijvm.language;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class MiniJvmColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Expression", MiniJvmSyntaxHighlighter.EXPRESSION),
            new AttributesDescriptor("Decimal parameter", MiniJvmSyntaxHighlighter.PARAM_DECIMAL),
            new AttributesDescriptor("Label parameter", MiniJvmSyntaxHighlighter.PARAM_LABEL),
            new AttributesDescriptor("Label", MiniJvmSyntaxHighlighter.LABEL),
            new AttributesDescriptor("Comment", MiniJvmSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Bad value", MiniJvmSyntaxHighlighter.BAD_CHARACTER)
    };

    @Override
    public @Nullable Icon getIcon() {
        return MiniJvmIcons.FILE;
    }

    @Override
    public @NotNull SyntaxHighlighter getHighlighter() {
        return new MiniJvmSyntaxHighlighter();
    }

    @Override
    public @NonNls @NotNull String getDemoText() {
        return "ALLOC 2     // int x, y;\n" +
                "READ        // x = read();\n" +
                "STORE 0\n" +
                "CONST 1     // y = 1;\n" +
                "STORE 1\n" +
                "\n" +
                "labelA:\n" +
                "    // while (1 < x)\n" +
                "    CONST 1\n" +
                "    LOAD 0\n" +
                "    LESS\n" +
                "    FJUMP labelB\n" +
                "\n" +
                "    // y = y * x;\n" +
                "    LOAD 1\n" +
                "    LOAD 0\n" +
                "    MUL\n" +
                "    STORE 1\n" +
                "\n" +
                "    // x = x - 1;\n" +
                "    LOAD 0\n" +
                "    CONST 1\n" +
                "    SUB\n" +
                "    STORE 0\n" +
                "    JUMP A\n" +
                "\n" +
                "labelB:\n" +
                "LOAD 1\n" +
                "WRITE\n" +
                "HALT";
    }

    @Override
    public @Nullable Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @Override
    public @NotNull String getDisplayName() {
        return "MiniJVM";
    }
}
