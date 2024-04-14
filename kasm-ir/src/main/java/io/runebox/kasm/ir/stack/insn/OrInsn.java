package io.runebox.kasm.ir.stack.insn;

import io.runebox.kasm.ir.type.IntType;
import io.runebox.kasm.ir.type.LongType;
import io.runebox.kasm.ir.type.Type;

/**
 * Pop two int/long values, calculate the logical or ('|' operator) and push the result.
 */
public class OrInsn extends AbstractBinaryMathInsn {
    public OrInsn(Type type) {
        super(type);
        if (!(type instanceof IntType) && !(type instanceof LongType)) {
            throw new IllegalArgumentException(type + " is not supported by logical or instruction");
        }
    }

    @Override
    protected boolean isTypeSupported(Type type) {
        return type instanceof IntType || type instanceof LongType;
    }
}
