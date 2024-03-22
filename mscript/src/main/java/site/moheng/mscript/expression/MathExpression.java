package site.moheng.mscript.expression;

import lombok.AllArgsConstructor;
import lombok.Value;
import site.moheng.mscript.antlr.MScriptParser;
import site.moheng.mscript.util.MathOperator;

@Value
@AllArgsConstructor(staticName = "of")
public class MathExpression implements IBinaryExpression<MathOperator> {
    IExpression left;
    IExpression right;
    MathOperator operator;

    public static MathExpression from(MScriptParser.ExprContext context) {
        return MathExpression.of(IExpression.from(context.left), IExpression.from(context.right), MathOperator.from(context.oper));
    }
}
