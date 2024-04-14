package io.runebox.kasm.ir.handle;

import io.runebox.kasm.ir.FieldRef;

public interface FieldHandle extends Handle {
    FieldRef getFieldRef();
}
