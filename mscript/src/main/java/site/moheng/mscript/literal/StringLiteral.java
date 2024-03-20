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
public record StringLiteral(String value) implements ILiteral {
    public static StringLiteral from(@NotNull TerminalNode node) {
        return from(node.getSymbol());
    }

    public static StringLiteral from(@NotNull Token token) {
        return StringLiteral.of(token.getText());
    }
}
