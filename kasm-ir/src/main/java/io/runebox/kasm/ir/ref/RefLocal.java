package io.runebox.kasm.ir.ref;

import io.runebox.kasm.ir.type.Type;
import io.runebox.kasm.ir.util.RCell;

import java.util.Set;

public class RefLocal implements Variable {
    /**
     * Type of this Local
     */
    private Type type;

    public RefLocal(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public Set<RCell<Expression>> getReadValueCells() {
        return Set.of();
    }
}
