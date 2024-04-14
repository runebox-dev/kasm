package io.runebox.kasm.ir.ref;

import io.runebox.kasm.ir.type.Type;

public interface Expression extends Referencing {
    /**
     * The type of this value
     */
    Type getType();
}
