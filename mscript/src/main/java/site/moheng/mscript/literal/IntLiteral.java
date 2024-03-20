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
public record IntLiteral(Integer value) implements ILiteral {
    public static IntLiteral from(@NotNull TerminalNode node) {
        return from(node.getSymbol());
    }

    public static IntLiteral from(@NotNull Token token) {
        return IntLiteral.of(Integer.parseInt(token.getText()));
    }
}
