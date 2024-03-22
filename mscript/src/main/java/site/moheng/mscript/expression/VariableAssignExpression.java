package site.moheng.mscript.expression;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import site.moheng.mscript.antlr.MScriptParser;

@Value
@AllArgsConstructor(staticName = "of")
public class VariableAssignExpression implements IExpression {
    VariableRefExpression variable;
    IExpression value;

    public static VariableAssignExpression from(@NotNull MScriptParser.ExprContext context) {
        return of(VariableRefExpression.from(context.ID()), IExpression.from(context.right));
    }
}
