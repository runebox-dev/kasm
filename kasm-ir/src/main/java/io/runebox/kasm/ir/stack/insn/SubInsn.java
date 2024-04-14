package io.runebox.kasm.ir.stack.insn;

import io.runebox.kasm.ir.type.DoubleType;
import io.runebox.kasm.ir.type.FloatType;
import io.runebox.kasm.ir.type.IntType;
import io.runebox.kasm.ir.type.LongType;
import io.runebox.kasm.ir.type.Type;

/**
 * Pop two numbers from the stack, subtract them and push the result onto the stack.
 */
public class SubInsn extends AbstractBinaryMathInsn {
    public SubInsn(Type type) {
        super(type);
    }

    @Override
    protected boolean isTypeSupported(Type type) {
        return type instanceof IntType || type instanceof LongType ||
                type instanceof FloatType || type instanceof DoubleType;
    }
}
