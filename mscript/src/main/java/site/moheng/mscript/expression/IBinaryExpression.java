package site.moheng.mscript.expression;

public interface IBinaryExpression<O> extends IExpression {
    IExpression getLeft();

    IExpression getRight();

    O getOperator();
}
