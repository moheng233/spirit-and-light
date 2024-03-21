package site.moheng.mscript.statement;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import site.moheng.mscript.antlr.MScriptParser;
import site.moheng.mscript.expression.IExpression;
import site.moheng.mscript.literal.IdentityLiteral;
import site.moheng.mscript.typeStatement.ITypeStatement;


@Value
@AllArgsConstructor(staticName = "of")
public class VarDefStatement implements IStatement {
    ITypeStatement type;
    IdentityLiteral identity;
    IExpression value;

    public static VarDefStatement from(@NotNull MScriptParser.VarDefStatContext context) {
        return VarDefStatement.of(ITypeStatement.from(context.type), IdentityLiteral.from(context.name), IExpression.from(context.value));
    }
}
