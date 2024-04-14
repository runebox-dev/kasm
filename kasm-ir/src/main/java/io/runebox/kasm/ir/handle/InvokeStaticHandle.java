package io.runebox.kasm.ir.handle;

import io.runebox.kasm.ir.MethodRef;

public class InvokeStaticHandle extends AbstractAmbiguousMethodHandle {
    public InvokeStaticHandle(MethodRef methodRef, boolean isInterface) {
        super(methodRef, isInterface);
    }
}
