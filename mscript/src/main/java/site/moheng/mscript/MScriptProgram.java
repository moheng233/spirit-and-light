package site.moheng.mscript;

import lombok.Builder;
import lombok.Singular;
import lombok.val;
import site.moheng.mscript.antlr.MScriptParser;
import site.moheng.mscript.statement.ClosureStatement;
import site.moheng.mscript.statement.VariableDefineStatement;

import java.util.List;

@Builder
public class MScriptProgram {

    @Singular
    public List<VariableDefineStatement> variableDefStatements;
    @Singular
    public List<ClosureStatement> closureStatements;

    public static MScriptProgram from(MScriptParser.ProgramContext context) throws Exception {
        val builder = new MScriptProgramBuilder();

        for (val varDef : context.varDefStat()) {
            builder.variableDefStatement(VariableDefineStatement.from(varDef));
        }

        for (val closure : context.closureStat()) {
            builder.closureStatement(ClosureStatement.from(closure));
        }

        return builder.build();
    }
}
