package io.runebox.kasm.ir.ref.condition;

import io.runebox.kasm.ir.ref.Expression;

/**
 * Check whether one number is less than another.
 */
public class LessThan extends Condition {
    public LessThan(Expression value1, Expression value2) {
        super(value1, value2);
    }

    @Override
    public GreaterEqual negate() {
        return new GreaterEqual(getValue1(), getValue2());
    }
}
