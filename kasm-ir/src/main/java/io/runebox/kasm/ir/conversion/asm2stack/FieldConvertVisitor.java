package io.runebox.kasm.ir.conversion.asm2stack;

import io.runebox.kasm.ir.Attribute;
import io.runebox.kasm.ir.Field;
import io.runebox.kasm.ir.annotation.Annotation;
import io.runebox.kasm.ir.typeannotation.FieldTypeAnnotation;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.TypePath;

/**
 * Visitor that converts all events and applies them to a {@link Field}.
 */
public class FieldConvertVisitor extends FieldVisitor {
    private final Field field;

    public FieldConvertVisitor(FieldVisitor fieldVisitor, Field field) {
        super(Opcodes.ASM7, fieldVisitor);
        this.field = field;
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        Annotation annotation = new Annotation(AsmUtil.pathFromObjectDescriptor(descriptor), visible);

        this.field.getAnnotations().add(annotation);

        AnnotationVisitor av = super.visitAnnotation(descriptor, visible);
        av = new AnnotationConvertVisitor(av, annotation);
        return av;
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        Annotation annotation = new Annotation(AsmUtil.pathFromObjectDescriptor(descriptor), visible);

        this.field.getTypeAnnotations().add(new FieldTypeAnnotation(AsmUtil.fromAsmTypePath(typePath), annotation));

        AnnotationVisitor av = super.visitTypeAnnotation(typeRef, typePath, descriptor, visible);
        av = new AnnotationConvertVisitor(av, annotation);
        return av;
    }

    @Override
    public void visitAttribute(org.objectweb.asm.Attribute attribute) {
        field.getAttributes().add(new Attribute(attribute.type, AsmUtil.getAttributeData(attribute)));
    }
}
