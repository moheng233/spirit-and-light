package site.moheng.mscript.expression;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import site.moheng.mscript.antlr.MScriptParser;
import site.moheng.mscript.literal.IdentityLiteral;

import java.util.List;

@Value
@AllArgsConstructor(staticName = "of")
public class VariableRefExpression implements IExpression {
    List<IdentityLiteral> identity;

    public static VariableRefExpression from(@NotNull MScriptParser.VariableContext context) {
        return of(IdentityLiteral.fromList(context.ID()));
    }
}
