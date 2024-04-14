package io.runebox.kasm.ir.ref.stmt;

import io.runebox.kasm.ir.ref.Expression;

/**
 * Acquire a lock on an object.
 *
 * @see MonitorExitStmt to release a lock
 */
public class MonitorEnterStmt extends AbstractUnaryStmt {
    public MonitorEnterStmt(Expression value) {
        super(value);
    }
}
