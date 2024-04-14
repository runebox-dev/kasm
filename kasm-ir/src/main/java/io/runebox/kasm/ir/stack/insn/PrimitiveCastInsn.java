package io.runebox.kasm.ir.stack.insn;

import io.runebox.kasm.ir.type.BooleanType;
import io.runebox.kasm.ir.type.DoubleType;
import io.runebox.kasm.ir.type.FloatType;
import io.runebox.kasm.ir.type.IntType;
import io.runebox.kasm.ir.type.LongType;
import io.runebox.kasm.ir.type.PrimitiveType;

/**
 * Pop a primitive value from the stack, cast it to another primitive type and push it again.
 *
 * @see RefCastInsn for casts of reference types
 */
public class PrimitiveCastInsn extends AbstractInstruction {
    /**
     * Type of the value before the cast.
     */
    private PrimitiveType fromType;

    /**
     * Type that the value will be casted to.
     */
    private PrimitiveType toType;

    public PrimitiveCastInsn(PrimitiveType fromType, PrimitiveType toType) {
        setFromType(fromType);
        setToType(toType);
    }

    public PrimitiveType getFromType() {
        return fromType;
    }

    public void setFromType(PrimitiveType fromType) {
        if (fromType instanceof IntType || fromType instanceof LongType ||
                fromType instanceof FloatType || fromType instanceof DoubleType) {
            this.fromType = fromType;
        } else {
            throw new IllegalArgumentException("Cast from " + fromType + " is not possible");
        }
    }

    public PrimitiveType getToType() {
        return toType;
    }

    public void setToType(PrimitiveType toType) {
        if (toType instanceof BooleanType) {
            throw new IllegalArgumentException("Cast to BooleanType are not possible");
        }

        this.toType = toType;
    }

    @Override
    public int getPushCount() {
        return 1;
    }

    @Override
    public int getPopCount() {
        return 1;
    }
}
