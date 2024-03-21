package site.moheng.mscript.statement;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import site.moheng.mscript.antlr.MScriptParser;
import site.moheng.mscript.literal.IdentityLiteral;
import site.moheng.mscript.typeStatement.ITypeStatement;
import site.moheng.mscript.util.ClosureArgs;

@Value
@AllArgsConstructor(staticName = "of")
public class ClosureStatement implements IStatement {
    ITypeStatement returnType;
    IdentityLiteral name;
    ClosureArgs args;
    BodyStatement body;

    public static ClosureStatement from(@NotNull MScriptParser.ClosureStatContext context) {
        return ClosureStatement.of(ITypeStatement.from(context.returnValue), IdentityLiteral.from(context.name), ClosureArgs.from(context.args), BodyStatement.from(context.body));
    }
}
