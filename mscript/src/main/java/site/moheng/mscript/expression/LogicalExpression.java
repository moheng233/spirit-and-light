package site.moheng.mscript.expression;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import site.moheng.mscript.antlr.MScriptParser;
import site.moheng.mscript.util.LogicalOperator;

@Value
@AllArgsConstructor(staticName = "of")
public class LogicalExpression implements IBinaryExpression<LogicalOperator> {
    IExpression left;
    IExpression right;
    LogicalOperator operator;

    public static LogicalExpression from(@NotNull MScriptParser.ExprContext context) {
        return of(IExpression.from(context.left), IExpression.from(context.right), LogicalOperator.from(context.oper));
    }
}
