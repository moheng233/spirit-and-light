package site.moheng.mscript.literal;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.NotNull;
import site.moheng.mscript.expression.IExpression;

@Value
@AllArgsConstructor(staticName = "of")
public class StringLiteral implements ILiteral, IExpression {
    String value;

    public static StringLiteral from(@NotNull TerminalNode node) {
        return from(node.getSymbol());
    }

    public static StringLiteral from(@NotNull Token token) {
        return StringLiteral.of(token.getText());
    }
}
