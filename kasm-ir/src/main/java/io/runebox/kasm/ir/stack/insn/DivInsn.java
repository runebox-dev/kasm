package io.runebox.kasm.ir.stack.insn;

import io.runebox.kasm.ir.type.*;

/**
 * Pop two numbers from the stack, divide them and push the result onto the stack.
 */
public class DivInsn extends AbstractBinaryMathInsn {
    public DivInsn(Type type) {
        super(type);
    }

    @Override
    protected boolean isTypeSupported(Type type) {
        return type instanceof IntType || type instanceof LongType ||
                type instanceof FloatType || type instanceof DoubleType;
    }
}
