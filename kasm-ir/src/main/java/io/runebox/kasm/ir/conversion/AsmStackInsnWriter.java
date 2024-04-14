package io.runebox.kasm.ir.conversion;

import io.runebox.kasm.ir.conversion.asm2stack.ConversionContext;
import io.runebox.kasm.ir.util.RWCell;
import io.runebox.kasm.ir.stack.StackLocal;
import io.runebox.kasm.ir.stack.insn.Instruction;
import io.runebox.kasm.ir.util.AbstractStackInsnWriter;
import org.objectweb.asm.tree.LabelNode;

/**
 * Instruction visitor that collects all events represented as {@link Instruction}.
 */
public class AsmStackInsnWriter extends AbstractStackInsnWriter<LabelNode, Integer> {
    private final ConversionContext ctx;

    public AsmStackInsnWriter(ConversionContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public void registerTargetCell(LabelNode label, RWCell<Instruction> cell) {
        ctx.registerForwardInsnCell(label, cell);
    }

    @Override
    public StackLocal convertLocal(Integer localIndex) {
        return ctx.getLocal(localIndex);
    }
}
