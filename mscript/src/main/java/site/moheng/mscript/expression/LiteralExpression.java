package site.moheng.mscript.expression;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import site.moheng.mscript.antlr.MScriptParser;
import site.moheng.mscript.literal.ILiteral;

@Value
@AllArgsConstructor(staticName = "of")
public class LiteralExpression implements IExpression {
    ILiteral literal;

    public static LiteralExpression from(@NotNull MScriptParser.ExprContext context) {
        return of(ILiteral.from(context.literal().value));
    }
}
