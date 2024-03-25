package site.moheng.mscript.statement;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import site.moheng.mscript.antlr.MScriptParser;
import site.moheng.mscript.expression.IExpression;
import site.moheng.mscript.literal.IdentityLiteral;
import site.moheng.mscript.typeStatement.ITypeStatement;

import java.util.List;


@Value
@AllArgsConstructor(staticName = "of")
public class VariableDefineStatement implements IStatement {
    ITypeStatement type;
    IdentityLiteral identity;
    IExpression value;

    public static VariableDefineStatement from(@NotNull MScriptParser.VarDefStatContext context) {
        return VariableDefineStatement.of(ITypeStatement.from(context.type), IdentityLiteral.from(context.name), IExpression.from(context.value));
    }

    public static List<VariableDefineStatement> fromList(@NotNull List<MScriptParser.VarDefStatContext> contexts) {
        return contexts.stream().map(VariableDefineStatement::from).toList();
    }
}
