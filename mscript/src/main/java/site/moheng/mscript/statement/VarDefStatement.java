package site.moheng.mscript.statement;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;
import site.moheng.mscript.antlr.MScriptParser;
import site.moheng.mscript.expression.IExpression;
import site.moheng.mscript.literal.IdentityLiteral;
import site.moheng.mscript.typeStatement.ITypeStatement;

@Value
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor(staticName = "of")
public record VarDefStatement(ITypeStatement type, IdentityLiteral identity, IExpression value) implements IStatement {
    public static VarDefStatement from(MScriptParser.VarDefStatContext context) {
        return VarDefStatement.of(ITypeStatement.from(context.type), IdentityLiteral.from(context.name), IExpression.from(context.value));
    }
}
