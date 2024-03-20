package site.moheng.mscript.literal;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.NotNull;
import site.moheng.mscript.antlr.MScriptParser;

public interface ILiteral {

    static ILiteral from(@NotNull TerminalNode node) {
        return from(node.getSymbol());
    }

    static ILiteral from(@NotNull Token token) {
        return switch (token.getType()) {
            case MScriptParser.ID -> IdentityLiteral.from(token);
            case MScriptParser.STRING -> StringLiteral.from(token);
            case MScriptParser.TRUE -> BooleanLiteral.of(true);
            case MScriptParser.FALSE -> BooleanLiteral.of(false);
            case MScriptParser.INT -> IntLiteral.from(token);
            case MScriptParser.FLOAT -> FloatLiteral.from(token);
            default -> null;
        };
    }
}
