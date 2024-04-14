package io.runebox.kasm.ir.stack.insn;

import io.runebox.kasm.ir.type.DoubleType;
import io.runebox.kasm.ir.type.FloatType;
import io.runebox.kasm.ir.type.Type;

/**
 * Pop two float/double values, compare them and push a result.
 *
 * If both numbers are equal push 0.
 * Otherwise either 1 or -1 is pushed,
 * depending on which number is greater.
 *
 * @see CmpgInsn has similar functionality but handles NaN different
 */
public class CmplInsn extends AbstractBinaryMathInsn {
    public CmplInsn(Type type) {
        super(type);
    }

    @Override
    protected boolean isTypeSupported(Type type) {
        return type instanceof FloatType || type instanceof DoubleType;
    }
}
