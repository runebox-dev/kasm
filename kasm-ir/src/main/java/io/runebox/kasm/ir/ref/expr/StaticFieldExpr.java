package io.runebox.kasm.ir.ref.expr;

import io.runebox.kasm.ir.FieldRef;
import io.runebox.kasm.ir.util.RCell;
import io.runebox.kasm.ir.ref.Expression;

import java.util.Set;

/**
 * Reference the value of a static field.
 */
public class StaticFieldExpr extends AbstractFieldExpr {
    public StaticFieldExpr(FieldRef field) {
        super(field);
    }

    @Override
    public Set<RCell<Expression>> getReadValueCells() {
        return Set.of();
    }
}
