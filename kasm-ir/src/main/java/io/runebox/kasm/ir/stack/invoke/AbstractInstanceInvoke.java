package io.runebox.kasm.ir.stack.invoke;

import io.runebox.kasm.ir.MethodRef;

/**
 * Invoke a method on an instance of a class
 */
public class AbstractInstanceInvoke extends AbstractConcreteInvoke {
    public AbstractInstanceInvoke(MethodRef method) {
        super(method);
    }
}
