package io.runebox.kasm.ir.conversion.stack2ref.processor;

import io.runebox.kasm.ir.type.*;
import io.runebox.kasm.ir.ref.RefBody;
import io.runebox.kasm.ir.ref.RefLocal;
import io.runebox.kasm.ir.ref.Statement;
import io.runebox.kasm.ir.ref.stmt.AssignStmt;

/**
 * Compute and assign types to all locals.
 * Unused locals cannot be typed and will therefore be removed.
 *
 * Since one JVM local may have multiple types at different locations in code,
 * the {@link LocalPartitioningPostProcessor} should be run first.
 * It will split such locals into multiple ones that may each have different types.
 */
public class LocalTypingPostProcessor implements PostProcessor {
    @Override
    public void process(RefBody body) {
        for (Statement statement : body.getStatements()) {
            if (statement instanceof AssignStmt) {
                AssignStmt assignment = (AssignStmt) statement;

                if (assignment.getVariable() instanceof RefLocal) {
                    RefLocal local = (RefLocal) assignment.getVariable();
                    Type requiredType = assignment.getValue().getType();
                    mergeType(local, requiredType);
                }
            }
        }

        body.getLocals().removeIf(local -> local.getType() == null);
    }

    /**
     * Assign a type to local or merge it with the current type of the local.
     *
     * @param local the local whose type gets modified
     * @param mergeType the type that the local should be able to store
     */
    private void mergeType(RefLocal local, Type mergeType) {
        Type currentType = local.getType();
        if (currentType == null) {
            local.setType(mergeType);
            return;
        }

        if (mergeType.equals(currentType)) {
            return;
        }

        if (mergeType instanceof RefType && currentType instanceof RefType) {
            // We have two different RefTypes, so we just set the type to 'java.lang.Object'.
            // Computing the 'greatest' common supertype would require that we have all their superclasses e.g. on the classpath.
            local.setType(ObjectType.OBJECT);
            return;
        }

        if (mergeType instanceof IntLikeType && currentType instanceof IntLikeType) {
            local.setType(IntType.getInstance());
            return;
        }

        throw new AssertionError("Cannot merge types " + mergeType + " and " + currentType);
    }
}
