package site.moheng.mscript.typeStatement;

import site.moheng.mscript.util.RuntimeType;

public class ObjectTypeLiteral implements ITypeLiteral {
    @Override
    public RuntimeType getType() {
        return RuntimeType.OBJECT;
    }
}
