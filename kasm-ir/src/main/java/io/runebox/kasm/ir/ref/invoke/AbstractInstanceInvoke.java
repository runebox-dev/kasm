package io.runebox.kasm.ir.ref.invoke;

import io.runebox.kasm.ir.MethodRef;
import io.runebox.kasm.ir.util.RCell;
import io.runebox.kasm.ir.util.RWCell;
import io.runebox.kasm.ir.ref.Expression;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Invoke a method of an instance of a class.
 */
public class AbstractInstanceInvoke extends AbstractConcreteInvoke {
    private Expression instance;

    public AbstractInstanceInvoke(MethodRef method, Expression instance, List<Expression> arguments) {
        super(method, arguments);
        this.instance = instance;
    }

    public Expression getInstance() {
        return instance;
    }

    public void setInstance(Expression instance) {
        this.instance = instance;
    }

    public RWCell<Expression> getInstanceCell() {
        return RWCell.of(this::getInstance, this::setInstance, Expression.class);
    }

    @Override
    public Set<RCell<Expression>> getReadValueCells() {
        return Stream.concat(Stream.of(getInstanceCell()), getArgumentCells().stream())
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AbstractInstanceInvoke that = (AbstractInstanceInvoke) o;
        return Objects.equals(instance, that.instance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), instance);
    }
}
