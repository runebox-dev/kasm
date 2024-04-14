package io.runebox.kasm.ir.typeannotation;

import io.runebox.kasm.ir.annotation.Annotation;

/**
 * Annotate the type of a field.
 */
public class FieldTypeAnnotation extends AbstractTypeAnnotation {
    public FieldTypeAnnotation(TypePath typePath, Annotation annotation) {
        super(typePath, annotation);
    }

    @Override
    public String toString() {
        return FieldTypeAnnotation.class.getSimpleName() + '{' +
                "typePath=" + getTypePath() +
                ", annotation=" + getAnnotation() +
                '}';
    }
}
