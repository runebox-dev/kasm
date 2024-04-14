package io.runebox.kasm.ir.ref.stmt;

import io.runebox.kasm.ir.ref.Expression;

/**
 * Release a lock on an object.
 *
 * @see MonitorEnterStmt to gain a lock
 */
public class MonitorExitStmt extends AbstractUnaryStmt {
    public MonitorExitStmt(Expression value) {
        super(value);
    }
}
