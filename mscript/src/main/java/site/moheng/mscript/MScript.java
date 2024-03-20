package site.moheng.mscript;

import lombok.Getter;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.jetbrains.annotations.NotNull;
import site.moheng.mscript.antlr.MScriptLexer;
import site.moheng.mscript.antlr.MScriptParser;

public class MScript {
    @Getter
    private final MScriptParser parser;

    public MScript(MScriptParser parser) {
        this.parser = parser;
    }

    public static @NotNull MScript from(TokenStream tokenStream) {
        return new MScript(new MScriptParser(tokenStream));
    }

    public static @NotNull MScript fromString(String src) {
        var lexer = new MScriptLexer(CharStreams.fromString(src));
        return MScript.from(new CommonTokenStream(lexer));
    }
}
