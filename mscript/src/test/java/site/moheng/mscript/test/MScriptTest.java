package site.moheng.mscript.test;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import site.moheng.mscript.MScript;
import site.moheng.mscript.MScriptProgram;

@DisplayName("Script Test")
public class MScriptTest {
    @Test
    public void getPayloadTest() {
        val src = """
                int a = 1;
                void a(int b) {
                    int b = 1 + a;
                }
                """;

        val mscript = MScript.fromString(src);
        val program = MScriptProgram.from(mscript.getParser().program());


    }
}
