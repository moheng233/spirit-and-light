package site.moheng.mscript.literal;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.NotNull;

@Value
@AllArgsConstructor(staticName = "of")
public class FloatLiteral implements ILiteral {
    Float value;

    public static FloatLiteral from(@NotNull TerminalNode node) {
        return from(node.getSymbol());
    }

    public static FloatLiteral from(@NotNull Token token) {
        return FloatLiteral.of(Float.parseFloat(token.getText()));
    }
}
