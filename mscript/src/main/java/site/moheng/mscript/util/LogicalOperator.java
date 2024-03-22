package site.moheng.mscript.util;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.IntSet;
import org.antlr.v4.runtime.misc.IntervalSet;
import org.jetbrains.annotations.NotNull;
import site.moheng.mscript.antlr.MScriptParser;

public enum LogicalOperator {
    AND,
    OR,
    EQ,
    NE,
    GT,
    LT,
    LE;

    public static final IntSet Tokens = new IntervalSet(MScriptParser.AND, MScriptParser.OR, MScriptParser.EQ, MScriptParser.NE, MScriptParser.GT, MScriptParser.LT, MScriptParser.LE);

    public static boolean isToken(@NotNull Token token) {
        return Tokens.contains(token.getType());
    }

    public static LogicalOperator from(@NotNull Token token) {
        return switch (token.getType()) {
            case MScriptParser.AND -> AND;
            case MScriptParser.OR -> OR;
            case MScriptParser.EQ -> EQ;
            case MScriptParser.NE -> NE;
            case MScriptParser.GT -> GT;
            case MScriptParser.LT -> LT;
            case MScriptParser.LE -> LE;

            default -> throw new IllegalStateException("Unexpected value: " + token.getType());
        };
    }
}
