package io.runebox.kasm.ir.ref.expr;

import io.runebox.kasm.ir.Path;
import io.runebox.kasm.ir.type.ObjectType;
import io.runebox.kasm.ir.type.Type;
import io.runebox.kasm.ir.util.RCell;
import io.runebox.kasm.ir.ref.Expression;

import java.util.Objects;
import java.util.Set;

/**
 * Create a new instance of a class.
 *
 * The constructor must be invoked to fully initialize that object.
 */
public class NewExpr implements Expression {
    /**
     * Name of the class whose instance should be created
     */
    private Path path;

    public NewExpr(Path path) {
        this.path = path;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    @Override
    public Type getType() {
        return new ObjectType(path);
    }

    @Override
    public Set<RCell<Expression>> getReadValueCells() {
        return Set.of();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewExpr expr = (NewExpr) o;
        return Objects.equals(path, expr.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }
}
