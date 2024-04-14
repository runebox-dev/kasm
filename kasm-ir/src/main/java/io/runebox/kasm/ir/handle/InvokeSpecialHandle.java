package io.runebox.kasm.ir.handle;

import io.runebox.kasm.ir.MethodRef;

public class InvokeSpecialHandle extends AbstractAmbiguousMethodHandle {
    public InvokeSpecialHandle(MethodRef methodRef, boolean isInterface) {
        super(methodRef, isInterface);
    }
}
