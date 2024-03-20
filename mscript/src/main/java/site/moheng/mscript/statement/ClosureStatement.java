package site.moheng.mscript.statement;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;
import site.moheng.mscript.antlr.MScriptParser;
import site.moheng.mscript.literal.IdentityLiteral;
import site.moheng.mscript.typeStatement.ITypeStatement;
import site.moheng.mscript.util.ClosureArgs;

@Value
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor(staticName = "of")
public record ClosureStatement(ITypeStatement returnType, IdentityLiteral name, ClosureArgs args,
                               BodyStatement body) implements IStatement {
    public static ClosureStatement from(MScriptParser.ClosureStatContext context) {
        return ClosureStatement.of(ITypeStatement.from(context.returnValue), IdentityLiteral.from(context.name), new ClosureArgs(), new BodyStatement());
    }
}
