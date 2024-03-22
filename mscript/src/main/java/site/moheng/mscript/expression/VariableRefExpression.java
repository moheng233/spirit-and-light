package site.moheng.mscript.expression;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.NotNull;
import site.moheng.mscript.antlr.MScriptParser;
import site.moheng.mscript.literal.IdentityLiteral;

@Value
@AllArgsConstructor(staticName = "of")
public class VariableRefExpression implements IExpression {
    IdentityLiteral identity;

    public static VariableRefExpression from(@NotNull MScriptParser.ExprContext context) {
        return of(IdentityLiteral.from(context.literal().value));
    }

    public static VariableRefExpression from(@NotNull TerminalNode node) {
        return of(IdentityLiteral.from(node));
    }
}
