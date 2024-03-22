package site.moheng.mscript.typeStatement;

import site.moheng.mscript.antlr.MScriptParser;

public interface ITypeStatement {
    static ITypeStatement from(MScriptParser.TypeExprContext context) {
        if (context.typeLiteral() != null) {
            if (context.typeLiteral().ID() != null) {
                return new ObjectTypeLiteral();
            }
            return TypeLiteral.create(context.typeLiteral());
        }

        return null;
    }
}
