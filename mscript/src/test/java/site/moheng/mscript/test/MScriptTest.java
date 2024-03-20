package site.moheng.mscript.test;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import site.moheng.mscript.MScript;

@DisplayName("Script Test")
public class MScriptTest {
    @Test
    void test() {
        String src = """
                var a = 1;
                var b = 2;
                bar c = 3;
                """;

        val script = MScript.fromString(src);
        val parser = script.getParser();
        var program = parser.program();

        for (val state : program.stat()) {

        }
    }
}
