package site.moheng.mscript.literal;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(staticName = "of")
public class BooleanLiteral implements ILiteral {
    Boolean value;
}
