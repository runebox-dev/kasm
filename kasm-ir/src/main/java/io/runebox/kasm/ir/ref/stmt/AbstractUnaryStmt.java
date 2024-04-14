package io.runebox.kasm.ir.ref.stmt;

import io.runebox.kasm.ir.util.RCell;
import io.runebox.kasm.ir.util.RWCell;
import io.runebox.kasm.ir.ref.Expression;
import io.runebox.kasm.ir.ref.Statement;

import java.util.Set;

public class AbstractUnaryStmt implements Statement {
    private Expression value;

    public AbstractUnaryStmt(Expression value) {
        this.value = value;
    }

    public Expression getValue() {
        return value;
    }

    public void setValue(Expression value) {
        this.value = value;
    }

    public RWCell<Expression> getValueCell() {
        return RWCell.of(this::getValue, this::setValue, Expression.class);
    }

    @Override
    public Set<RCell<Expression>> getReadValueCells() {
        return Set.of(getValueCell());
    }
}
