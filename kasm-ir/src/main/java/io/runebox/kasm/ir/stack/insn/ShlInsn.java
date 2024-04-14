package io.runebox.kasm.ir.stack.insn;

import io.runebox.kasm.ir.type.IntType;
import io.runebox.kasm.ir.type.LongType;
import io.runebox.kasm.ir.type.Type;

/**
 * Pop a long/int and a int value from the stack.
 * Shift the bits of the long/int value to the left and push the result.
 */
public class ShlInsn extends AbstractBinaryMathInsn {
    public ShlInsn(Type type) {
        super(type);
    }

    @Override
    protected boolean isTypeSupported(Type type) {
        return type instanceof IntType || type instanceof LongType;
    }
}
