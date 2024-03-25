package site.moheng.mscript.literal;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Value
@AllArgsConstructor(staticName = "of")
public class IdentityLiteral implements ILiteral {
    String value;

    public static IdentityLiteral from(@NotNull TerminalNode node) {
        return from(node.getSymbol());
    }

    public static IdentityLiteral from(@NotNull Token token) {
        return IdentityLiteral.of(token.getText());
    }

    public static List<IdentityLiteral> fromList(@NotNull List<TerminalNode> nodes) {
        return nodes.stream().map(IdentityLiteral::from).toList();
    }

    public static List<IdentityLiteral> fromTokenList(@NotNull List<Token> nodes) {
        return nodes.stream().map(IdentityLiteral::from).toList();
    }
}
