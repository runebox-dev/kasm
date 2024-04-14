package io.runebox.kasm.ir.stack.insn;

import io.runebox.kasm.ir.FieldRef;

/**
 * Read a value from a field.
 */
public class FieldGetInsn extends AbstractFieldInsn {
    public FieldGetInsn(FieldRef field, boolean isStatic) {
        super(field, isStatic);
    }

    @Override
    public int getPushCount() {
        return 1;
    }

    @Override
    public int getPopCount() {
        return isStatic() ? 0 : 1;
    }
}
