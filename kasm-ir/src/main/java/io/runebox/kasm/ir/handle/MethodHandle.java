package io.runebox.kasm.ir.handle;

import io.runebox.kasm.ir.MethodRef;

public interface MethodHandle extends Handle {
    MethodRef getMethodRef();
}
