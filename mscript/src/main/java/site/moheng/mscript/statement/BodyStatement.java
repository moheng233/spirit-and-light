package site.moheng.mscript.statement;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import site.moheng.mscript.antlr.MScriptParser;

import java.util.List;

@Value
@AllArgsConstructor(staticName = "of")
public class BodyStatement implements IStatement {
    List<IStatement> statements;

    public static BodyStatement from(@NotNull MScriptParser.BodyStatContext context) {
        return BodyStatement.of(context.stats.stream().map(IStatement::from).toList());
    }
}
