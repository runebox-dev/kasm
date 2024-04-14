package io.runebox.kasm.ir.ref.expr;

import io.runebox.kasm.ir.type.Type;
import io.runebox.kasm.ir.ref.Expression;

/**
 * Instructions that subtracts two numeric values.
 */
public class SubExpr extends AbstractBinaryExpr {
    public SubExpr(Expression value1, Expression value2) {
        super(value1, value2);
    }

    @Override
    public Type getType() {
        Type type1 = getValue1().getType();
        Type type2 = getValue2().getType();
        if (type1.equals(type2)) {
            return type1;
        } else {
            throw new IllegalStateException("Cannot subtract values of types " + type1 + " and " + type2);
        }
    }
}
