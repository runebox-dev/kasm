package io.runebox.kasm.ir.conversion.ref2stack;

import io.runebox.kasm.ir.util.RWCell;
import io.runebox.kasm.ir.ref.RefLocal;
import io.runebox.kasm.ir.ref.Statement;
import io.runebox.kasm.ir.stack.StackLocal;
import io.runebox.kasm.ir.stack.insn.Instruction;
import io.runebox.kasm.ir.util.AbstractStackInsnWriter;

/**
 * Instruction visitor that collects all events represented as {@link Instruction} and
 * registers instruction references to a {@link ConversionContext}.
 */
public class StackInsnWriter extends AbstractStackInsnWriter<Statement, RefLocal> {
    private final ConversionContext ctx;

    public StackInsnWriter(ConversionContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public void registerTargetCell(Statement target, RWCell<Instruction> cell) {
        this.ctx.registerInstructionReference(target, cell);
    }

    @Override
    public StackLocal convertLocal(RefLocal refLocal) {
        return ctx.getStackLocal(refLocal);
    }
}
