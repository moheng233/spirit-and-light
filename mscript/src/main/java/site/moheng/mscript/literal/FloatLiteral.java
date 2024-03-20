package site.moheng.mscript.literal;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.NotNull;

@Value
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor(staticName = "of")
public record FloatLiteral(Float value) implements ILiteral {
    public static FloatLiteral from(@NotNull TerminalNode node) {
        return from(node.getSymbol());
    }

    public static FloatLiteral from(@NotNull Token token) {
        return FloatLiteral.of(Float.parseFloat(token.getText()));
    }
}
