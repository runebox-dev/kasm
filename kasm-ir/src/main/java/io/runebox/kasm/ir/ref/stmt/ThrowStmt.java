package io.runebox.kasm.ir.ref.stmt;

import io.runebox.kasm.ir.ref.Expression;

/**
 * Throw an exception
 */
public class ThrowStmt extends AbstractUnaryStmt {
    public ThrowStmt(Expression value) {
        super(value);
    }

    @Override
    public boolean continuesExecution() {
        return false;
    }
}
