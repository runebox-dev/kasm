package io.runebox.kasm.ir.stack.insn;

import io.runebox.kasm.ir.type.DoubleType;
import io.runebox.kasm.ir.type.FloatType;
import io.runebox.kasm.ir.type.IntType;
import io.runebox.kasm.ir.type.LongType;
import io.runebox.kasm.ir.type.RefType;
import io.runebox.kasm.ir.type.Type;
import io.runebox.kasm.ir.stack.StackLocal;

/**
 * Push a value from a local onto the stack.
 */
public class LoadInsn extends AbstractTypeInsn {
    /**
     * Local whose value will be pushed onto the stack
     */
    private StackLocal local;

    public LoadInsn(Type type, StackLocal local) {
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
        return 1;
    }

    @Override
    public int getPopCount() {
        return 0;
    }
}
