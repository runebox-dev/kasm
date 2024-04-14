package io.runebox.kasm.ir.conversion.asm2stack;

import io.runebox.kasm.ir.util.RWCell;
import io.runebox.kasm.ir.stack.StackLocal;
import io.runebox.kasm.ir.stack.insn.Instruction;
import org.objectweb.asm.tree.LabelNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConversionContext {
    private List<StackLocal> locals = new ArrayList<>();

    /**
     * Instruction cells that should be assigned to the converted instruction that
     * <b>succeeds</b> the corresponding {@link LabelNode}.
     */
    private Map<LabelNode, List<RWCell<Instruction>>> forwardLabelCells = new HashMap<>();

    /**
     * Instruction cells that should be assigned to the converted instruction that
     * <b>precedes</b> the corresponding {@link LabelNode}.
     */
    private Map<LabelNode, List<RWCell<Instruction>>> backwardLabelCells = new HashMap<>();

    public StackLocal getLocal(int index) {
        return this.locals.get(index);
    }

    public void registerForwardInsnCell(LabelNode label, RWCell<Instruction> insnCell) {
        this.forwardLabelCells.computeIfAbsent(label, x -> new ArrayList<>()).add(insnCell);
    }

    public void registerBackwardInsnCell(LabelNode label, RWCell<Instruction> insnCell) {
        this.backwardLabelCells.computeIfAbsent(label, x -> new ArrayList<>()).add(insnCell);
    }

    public List<StackLocal> getLocals() {
        return locals;
    }

    public Map<LabelNode, List<RWCell<Instruction>>> getForwardLabelCells() {
        return forwardLabelCells;
    }

    public Map<LabelNode, List<RWCell<Instruction>>> getBackwardLabelCells() {
        return backwardLabelCells;
    }
}
