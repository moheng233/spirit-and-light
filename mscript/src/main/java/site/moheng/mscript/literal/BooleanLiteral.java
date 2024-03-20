package site.moheng.mscript.literal;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor(staticName = "of")
public record BooleanLiteral(Boolean value) implements ILiteral {

}
