package io.runebox.kasm.ir.conversion.stack2ref.processor;

import io.runebox.kasm.ir.ref.RefBody;

/**
 * Apply patches to an already build RefBody
 */
public interface PostProcessor {
    public void process(RefBody body);
}
