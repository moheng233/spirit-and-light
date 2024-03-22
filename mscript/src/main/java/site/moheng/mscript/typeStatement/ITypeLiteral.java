package site.moheng.mscript.typeStatement;

import site.moheng.mscript.util.RuntimeType;

public interface ITypeLiteral extends ITypeStatement {
    RuntimeType getType();
}
