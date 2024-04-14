package io.runebox.kasm.ir.stack.insn;

import io.runebox.kasm.ir.type.DoubleType;
import io.runebox.kasm.ir.type.FloatType;
import io.runebox.kasm.ir.type.IntType;
import io.runebox.kasm.ir.type.LongType;
import io.runebox.kasm.ir.type.RefType;
import io.runebox.kasm.ir.type.Type;

/**
 * Pop an array, an index and a value.
 * The value will be stored in the array at the index.
 */
public class ArrayStoreInsn extends AbstractTypeInsn {
    /**
     * Create an array store instruction
     *
     * @param type the type of the value that gets stored in the array
     */
    public ArrayStoreInsn(Type type) {
        super(type);
    }

    @Override
    protected boolean isTypeSupported(Type type) {
        return type instanceof RefType ||
                type instanceof IntType || type instanceof LongType ||
                type instanceof FloatType || type instanceof DoubleType;
    }

    @Override
    public int getPushCount() {
        return 0;
    }

    @Override
    public int getPopCount() {
        return 3;
    }
}
