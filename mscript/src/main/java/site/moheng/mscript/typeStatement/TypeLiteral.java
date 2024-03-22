package site.moheng.mscript.typeStatement;

import lombok.Getter;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.NotNull;
import site.moheng.mscript.antlr.MScriptParser;
import site.moheng.mscript.util.RuntimeType;

public enum TypeLiteral implements ITypeLiteral {
    VOID(RuntimeType.VOID),
    BOOLEAN(RuntimeType.BOOLEAN),
    INT(RuntimeType.INT),
    FLOAT(RuntimeType.FLOAT),
    STRING(RuntimeType.STRING);

    @Getter private final RuntimeType type;

    TypeLiteral(RuntimeType type) {
        this.type = type;
    }


    public static TypeLiteral create(@NotNull MScriptParser.TypeLiteralContext context) {
        return switch (context.getChild(TerminalNode.class, 0).getSymbol().getType()) {
            case MScriptParser.VOID -> VOID;
            case MScriptParser.TYPE_BOOL -> BOOLEAN;
            case MScriptParser.TYPE_INT -> INT;
            case MScriptParser.TYPE_FLOAT -> FLOAT;
            case MScriptParser.TYPE_STRING -> STRING;
            default ->
                    throw new IllegalStateException("Unexpected value: " + context.getChild(TerminalNode.class, 0).getSymbol().getType());
        };
    }
}
