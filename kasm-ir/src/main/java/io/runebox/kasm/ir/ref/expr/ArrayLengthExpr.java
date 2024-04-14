package io.runebox.kasm.ir.ref.expr;

import io.runebox.kasm.ir.type.IntType;
import io.runebox.kasm.ir.type.Type;
import io.runebox.kasm.ir.util.RCell;
import io.runebox.kasm.ir.util.RWCell;
import io.runebox.kasm.ir.ref.Expression;

import java.util.Objects;
import java.util.Set;

/**
 * Get the length of an array.
 */
public class ArrayLengthExpr implements Expression {
    /**
     * Array whose length is requested.
     */
    private Expression array;

    public ArrayLengthExpr(Expression array) {
        this.array = array;
    }

    public Expression getArray() {
        return array;
    }

    public void setArray(Expression array) {
        this.array = array;
    }

    public RWCell<Expression> getArrayCell() {
        return RWCell.of(this::getArray, this::setArray, Expression.class);
    }

    @Override
    public Type getType() {
        return IntType.getInstance();
    }

    @Override
    public Set<RCell<Expression>> getReadValueCells() {
        return Set.of(getArrayCell());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayLengthExpr expr = (ArrayLengthExpr) o;
        return Objects.equals(array, expr.array);
    }

    @Override
    public int hashCode() {
        return Objects.hash(array);
    }
}
