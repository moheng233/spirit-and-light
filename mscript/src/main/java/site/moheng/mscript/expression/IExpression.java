package site.moheng.mscript.expression;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import site.moheng.mscript.antlr.MScriptParser;
import site.moheng.mscript.util.LogicalOperator;
import site.moheng.mscript.util.MathOperator;

public interface IExpression {
    static @Nullable IExpression from(@NotNull MScriptParser.ExprContext context) {
        if (context.oper != null && context.left != null && context.right != null) {
            if (MathOperator.isToken(context.oper)) {
                return MathExpression.from(context);
            }
            if (LogicalOperator.isToken(context.oper)) {
                return LogicalExpression.from(context);
            }
        }
        if (context.literal() != null) {
            if (context.literal().value.getType() == MScriptParser.ID) {
                return VariableRefExpression.from(context);
            } else {
                return LiteralExpression.from(context);
            }
        }

        return null;
    }
}
