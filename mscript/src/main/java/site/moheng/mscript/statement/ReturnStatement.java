package site.moheng.mscript.statement;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import site.moheng.mscript.antlr.MScriptParser;
import site.moheng.mscript.expression.IExpression;

@Value
@AllArgsConstructor(staticName = "of")
public class ReturnStatement implements IStatement {
    IExpression expression;

    public static ReturnStatement from(@NotNull MScriptParser.ReturnStatContext context) {
        return of(IExpression.from(context.value));
    }
}
