package org.example;

import java.io.IOException;

public class TestJavaStackTrace {
    public static void dumpStackTrace() throws IOException {
        outermost();
    }

    private static void outermost() throws IOException {
        try {
            middle(0);
        }
        catch (final IOException e) {
            throw new IOException("Outermost", e);
        }
    }

    private static void middle(final int recursiveCount) throws IOException {
        if (recursiveCount < 5) {
            middle(recursiveCount + 1);
            return;
        }

        try {
            crashFromNestedClassAndLambda();
        }
        catch (final Throwable e) {
            throw new IOException("Middle exception", e);
        }
    }

    private static void crashFromNestedClassAndLambda() {
        RUNNABLE.run();
    }

    private static final Runnable RUNNABLE = () -> {
        new NestedClass().innermost();
    };

    private static class NestedClass {
        public void innermost() {
            throw new IllegalStateException("Inneermost");
        }
    }
}
