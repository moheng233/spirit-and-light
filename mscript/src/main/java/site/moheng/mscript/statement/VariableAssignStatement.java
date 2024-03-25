package site.moheng.mscript.statement;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import site.moheng.mscript.antlr.MScriptParser;
import site.moheng.mscript.expression.IExpression;
import site.moheng.mscript.expression.VariableRefExpression;

@Value
@AllArgsConstructor(staticName = "of")
public class VariableAssignStatement implements IStatement {
    VariableRefExpression variable;
    IExpression value;

    public static VariableAssignStatement from(@NotNull MScriptParser.AssignStatContext context) {
        return of(VariableRefExpression.from(context.variable()), IExpression.from(context.value));
    }
}
