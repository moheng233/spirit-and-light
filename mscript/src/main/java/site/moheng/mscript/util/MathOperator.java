package site.moheng.mscript.util;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.IntSet;
import org.antlr.v4.runtime.misc.IntervalSet;
import org.jetbrains.annotations.NotNull;
import site.moheng.mscript.antlr.MScriptParser;

public enum MathOperator {
    PLUS,
    LESS,
    TIMES,
    DIVIDE;

    public static final IntSet Tokens = new IntervalSet(MScriptParser.PLUS, MScriptParser.LESS, MScriptParser.TIMES, MScriptParser.DIVIDE);

    MathOperator() {

    }

    public static boolean isToken(Token token) {
        return Tokens.contains(token.getType());
    }

    public static MathOperator from(@NotNull Token token) {
        return switch (token.getType()) {
            case MScriptParser.PLUS -> PLUS;
            case MScriptParser.LESS -> LESS;
            case MScriptParser.TIMES -> TIMES;
            case MScriptParser.DIVIDE -> DIVIDE;

            default -> throw new IllegalStateException("Unexpected value: " + token.getType());
        };
    }
}
