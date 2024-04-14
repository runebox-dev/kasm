package io.runebox.kasm.ir.stack.invoke;

import io.runebox.kasm.ir.MethodRef;

/**
 * Invoke an instance method of an interface.
 */
public class InterfaceInvoke extends AbstractInstanceInvoke {
    public InterfaceInvoke(MethodRef method) {
        super(method);
    }
}
