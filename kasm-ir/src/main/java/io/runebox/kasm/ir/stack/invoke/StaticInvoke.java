package io.runebox.kasm.ir.stack.invoke;

import io.runebox.kasm.ir.MethodRef;

/**
 * Invoke a static method.
 */
public class StaticInvoke extends AbstractConcreteInvoke {
    /**
     * Is the invoked method declared within an interface
     */
    private boolean isInterface;

    public StaticInvoke(MethodRef method, boolean isInterface) {
        super(method);
        this.isInterface = isInterface;
    }

    public boolean isInterface() {
        return isInterface;
    }

    public void setInterface(boolean isInterface) {
        this.isInterface = isInterface;
    }
}
