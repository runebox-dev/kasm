package io.runebox.kasm.ir.ref.invoke;

import io.runebox.kasm.ir.MethodRef;
import io.runebox.kasm.ir.ref.Expression;

import java.util.List;

public class InvokeInterface extends AbstractInstanceInvoke {
    public InvokeInterface(MethodRef method, Expression instance, List<Expression> arguments) {
        super(method, instance, arguments);
    }
}
