package site.moheng.mscript.util;

import lombok.AllArgsConstructor;
import lombok.Value;
import site.moheng.mscript.antlr.MScriptParser;

import java.util.List;

@Value
@AllArgsConstructor(staticName = "of")
public class ClosureArgs {
    List<ClosureUniArg> args;

    public static ClosureArgs from(MScriptParser.ArgDefContext context) {
        return of(context.args.stream().map((ClosureUniArg::from)).toList());
    }
}
