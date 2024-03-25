package site.moheng.mscript.statement;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import site.moheng.mscript.antlr.MScriptParser;
import site.moheng.mscript.literal.IdentityLiteral;

import java.util.List;

@Value
@AllArgsConstructor(staticName = "of")
public class StructDefineStatement implements IStatement {
    IdentityLiteral name;
    List<IdentityLiteral> extend;
    List<VariableDefineStatement> fields;
    List<ClosureStatement> closures;

    public static StructDefineStatement from(@NotNull MScriptParser.StructDefStatContext context) {
        return of(IdentityLiteral.from(context.name), IdentityLiteral.fromTokenList(context.extends_), VariableDefineStatement.fromList(context.vars), ClosureStatement.fromList(context.closures));
    }
}
