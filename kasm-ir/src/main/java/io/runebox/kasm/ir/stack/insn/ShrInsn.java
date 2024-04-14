package io.runebox.kasm.ir.stack.insn;

import io.runebox.kasm.ir.type.IntType;
import io.runebox.kasm.ir.type.LongType;
import io.runebox.kasm.ir.type.Type;

/**
 * Pop a long/int and a int value from the stack.
 * Shift the bits of the long/int value to the right and push the result.
 *
 * @see UShrInsn same functionality but does not preserve the sign.
 */
public class ShrInsn extends AbstractBinaryMathInsn {
    public ShrInsn(Type type) {
        super(type);
    }

    @Override
    protected boolean isTypeSupported(Type type) {
        return type instanceof IntType || type instanceof LongType;
    }
}
