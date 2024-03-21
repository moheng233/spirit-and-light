package site.moheng.mscript.test;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import site.moheng.mscript.MScript;

@DisplayName("Script Test")
public class MScriptTest {
    @Test
    public void getPayloadTest() {
        val src = """
                void a(int b) {
                }
                """;

        val mscript = MScript.fromString(src);
        val program = mscript.getParser().program();

        program.getPayload();
    }
}
