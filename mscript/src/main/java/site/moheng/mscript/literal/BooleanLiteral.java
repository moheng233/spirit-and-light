package site.moheng.mscript.literal;

import lombok.AllArgsConstructor;
import lombok.Value;
import site.moheng.mscript.expression.IExpression;

@Value
@AllArgsConstructor(staticName = "of")
public class BooleanLiteral implements ILiteral, IExpression {
    Boolean value;
}
