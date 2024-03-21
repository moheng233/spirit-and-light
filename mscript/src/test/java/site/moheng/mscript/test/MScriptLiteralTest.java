package site.moheng.mscript.test;

import lombok.val;
import org.antlr.v4.runtime.CharStreams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import site.moheng.mscript.antlr.MScriptLexer;
import site.moheng.mscript.literal.BooleanLiteral;
import site.moheng.mscript.literal.FloatLiteral;
import site.moheng.mscript.literal.ILiteral;

@DisplayName("Literal parser test")
public class MScriptLiteralTest {

    private static ILiteral getLiteral(String source) {
        val lexer = new MScriptLexer(CharStreams.fromString(source));
        return ILiteral.from(lexer.nextToken());
    }

    @ParameterizedTest()
    @ValueSource(strings = {"true", "false"})
    public void booleanLiteral(String source) {
        final var literal = getLiteral(source);

        Assertions.assertInstanceOf(BooleanLiteral.class, literal);
    }

    @ParameterizedTest()
    @ValueSource(strings = {"1.1", "2.4", "8.8"})
    public void floatLiteral(String source) {
        final var literal = getLiteral(source);

        Assertions.assertInstanceOf(FloatLiteral.class, literal);
    }
}
