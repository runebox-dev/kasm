package io.runebox.kasm.ir.type;

public class BooleanType implements IntLikeType {
    private static final BooleanType INSTANCE = new BooleanType();

    public static BooleanType getInstance() {
        return INSTANCE;
    }

    private BooleanType() {}

    @Override
    public String toString() {
        return BooleanType.class.getSimpleName() + "{}";
    }
}
