package io.runebox.kasm.ir.conversion;

import io.runebox.kasm.ir.conversion.ref2stack.BodyConverter;
import io.runebox.kasm.ir.Classfile;
import io.runebox.kasm.ir.Method;
import io.runebox.kasm.ir.ref.RefBody;
import io.runebox.kasm.ir.stack.StackBody;

import java.util.Optional;

/**
 * Facade for conversions from the ref to the stack intermediation.
 */
public class Ref2Stack {
    /**
     * Take a {@link Classfile} that has only {@link RefBody RefBodies} and convert those into {@link StackBody StackBodies}.
     *
     * @param classfile the classfile whose bodies should get converted
     */
    public static void convert(Classfile classfile) {
        for (Method method : classfile.getMethods()) {
            method.getBody().ifPresent(body -> {
                if (body instanceof RefBody) {
                    method.setBody(Optional.of(convert((RefBody) body)));
                } else {
                    throw new IllegalArgumentException("Expected RefBody found " + body.getClass().getSimpleName());
                }
            });
        }
    }

    /**
     * Convert a {@link RefBody} into a {@link StackBody}.
     *
     * @param refBody the {@link RefBody} that should get converted
     * @return the converted {@link StackBody}
     */
    public static StackBody convert(RefBody refBody) {
        BodyConverter converter = new BodyConverter(refBody);
        converter.convert();
        return converter.getStackBody();
    }
}
