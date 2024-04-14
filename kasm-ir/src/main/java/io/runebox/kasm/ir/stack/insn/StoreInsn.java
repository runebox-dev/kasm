package io.runebox.kasm.ir.stack.insn;

import io.runebox.kasm.ir.type.DoubleType;
import io.runebox.kasm.ir.type.FloatType;
import io.runebox.kasm.ir.type.IntType;
import io.runebox.kasm.ir.type.LongType;
import io.runebox.kasm.ir.type.RefType;
import io.runebox.kasm.ir.type.Type;
import io.runebox.kasm.ir.stack.StackLocal;

/**
 * Store the upper value of the stack in a local.
 */
public class StoreInsn extends AbstractTypeInsn {
    private StackLocal local;

    public StoreInsn(Type type, StackLocal local) {
        super(type);
        this.local = local;
    }

    @Override
    protected boolean isTypeSupported(Type type) {
        return type instanceof RefType ||
                type instanceof IntType || type instanceof LongType ||
                type instanceof FloatType || type instanceof DoubleType;
    }

    public StackLocal getLocal() {
        return local;
    }

    public void setLocal(StackLocal local) {
        this.local = local;
    }

    @Override
    public int getPushCount() {
        return 0;
    }

    @Override
    public int getPopCount() {
        return 1;
    }
}
