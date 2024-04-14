package io.runebox.kasm.ir.type;

public class FloatType implements PrimitiveType {
    private static final FloatType INSTANCE = new FloatType();

    public static FloatType getInstance() {
        return INSTANCE;
    }

    private FloatType() {}

    @Override
    public String toString() {
        return FloatType.class.getSimpleName() + "{}";
    }
}
