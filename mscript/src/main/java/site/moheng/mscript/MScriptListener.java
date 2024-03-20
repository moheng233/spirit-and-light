package site.moheng.mscript;

import site.moheng.mscript.antlr.MScriptBaseListener;
import site.moheng.mscript.antlr.MScriptParser;

public class MScriptListener extends MScriptBaseListener {
    @Override
    public void enterProgram(MScriptParser.ProgramContext ctx) {
        super.enterProgram(ctx);
    }
}
