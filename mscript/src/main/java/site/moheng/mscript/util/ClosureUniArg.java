package site.moheng.mscript.util;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import site.moheng.mscript.antlr.MScriptParser;
import site.moheng.mscript.literal.IdentityLiteral;
import site.moheng.mscript.typeStatement.ITypeStatement;

@Value
@AllArgsConstructor(staticName = "of")
public class ClosureUniArg {
    ITypeStatement type;
    IdentityLiteral name;

    public static ClosureUniArg from(@NotNull MScriptParser.UniArgDefContext context) {
        return of(ITypeStatement.from(context.type), IdentityLiteral.from(context.name));
    }
}
