package io.runebox.kasm.ir.handle;

import io.runebox.kasm.ir.FieldRef;

import java.util.Objects;

public abstract class AbstractFieldHandle implements FieldHandle {
    private final FieldRef fieldRef;

    public AbstractFieldHandle(FieldRef fieldRef) {
        this.fieldRef = fieldRef;
    }

    public FieldRef getFieldRef() {
        return fieldRef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        io.runebox.kasm.ir.handle.AbstractFieldHandle that = (io.runebox.kasm.ir.handle.AbstractFieldHandle) o;
        return Objects.equals(fieldRef, that.fieldRef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldRef);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + '{' +
                "fieldRef=" + fieldRef +
                '}';
    }
}
