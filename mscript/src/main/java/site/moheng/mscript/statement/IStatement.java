package site.moheng.mscript.statement;

import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;
import site.moheng.mscript.antlr.MScriptParser;
import site.moheng.mscript.runtime.IRuntimeScope;

public interface IStatement {
    static @Nullable @Unmodifiable IStatement from(@NotNull MScriptParser.StatContext context) {
        val state = context.getChild(0);

        if (state instanceof MScriptParser.VarDefStatContext varDef) {
            return VarDefStatement.from(varDef);
        } else if (state instanceof MScriptParser.ClosureStatContext closure) {
            return ClosureStatement.from(closure);
        } else if (state instanceof MScriptParser.ReturnStatContext returnStat) {
            return ReturnStatement.from(returnStat);
        } else if (state instanceof MScriptParser.BodyStatContext body) {
            return BodyStatement.from(body);
        }

        return null;
    }

    void exec(IRuntimeScope scope);
}
