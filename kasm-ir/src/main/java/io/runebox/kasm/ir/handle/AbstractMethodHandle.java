package io.runebox.kasm.ir.handle;

import io.runebox.kasm.ir.MethodRef;

import java.util.Objects;

public abstract class AbstractMethodHandle implements MethodHandle {
    private final MethodRef methodRef;

    public AbstractMethodHandle(MethodRef methodRef) {
        this.methodRef = methodRef;
    }

    public MethodRef getMethodRef() {
        return methodRef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        io.runebox.kasm.ir.handle.AbstractMethodHandle that = (io.runebox.kasm.ir.handle.AbstractMethodHandle) o;
        return Objects.equals(methodRef, that.methodRef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(methodRef);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + '{' +
                "methodRef=" + methodRef +
                '}';
    }
}
