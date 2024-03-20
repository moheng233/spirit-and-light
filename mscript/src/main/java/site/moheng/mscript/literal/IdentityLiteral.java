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
public record IdentityLiteral(String value) implements ILiteral {
    public static IdentityLiteral from(@NotNull TerminalNode node) {
        return from(node.getSymbol());
    }

    public static IdentityLiteral from(@NotNull Token token) {
        return IdentityLiteral.of(token.getText());
    }
}
