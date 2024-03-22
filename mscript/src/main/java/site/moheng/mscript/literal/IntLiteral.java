package site.moheng.mscript.literal;

import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.NotNull;
import site.moheng.mscript.expression.IExpression;

@AllArgsConstructor(staticName = "of")
public class IntLiteral implements ILiteral, IExpression {
    int value;

    public static IntLiteral from(@NotNull TerminalNode node) {
        return from(node.getSymbol());
    }

    public static IntLiteral from(@NotNull Token token) {
        return IntLiteral.of(Integer.parseInt(token.getText()));
    }
}
