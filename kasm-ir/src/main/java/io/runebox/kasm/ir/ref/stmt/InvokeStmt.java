package io.runebox.kasm.ir.ref.stmt;

import io.runebox.kasm.ir.util.RCell;
import io.runebox.kasm.ir.ref.Expression;
import io.runebox.kasm.ir.ref.Statement;
import io.runebox.kasm.ir.ref.expr.InvokeExpr;
import io.runebox.kasm.ir.ref.invoke.AbstractInvoke;

import java.util.Set;

/**
 * Invoke a method without storing the return value.
 *
 * @see InvokeExpr to get the return value
 */
public class InvokeStmt implements Statement {
    private AbstractInvoke invoke;

    public InvokeStmt(AbstractInvoke invoke) {
        this.invoke = invoke;
    }

    public AbstractInvoke getInvoke() {
        return invoke;
    }

    public void setInvoke(AbstractInvoke invoke) {
        this.invoke = invoke;
    }

    @Override
    public Set<RCell<Expression>> getReadValueCells() {
        return invoke.getReadValueCells();
    }
}
