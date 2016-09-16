package com.robinkanters.athena.util.dummy;

import java.io.OutputStream;
import java.io.PrintStream;

public class DummyPrintStream extends PrintStream {
    public DummyPrintStream() {
        super(new DummyOutputStream());
    }

    public DummyPrintStream(OutputStream stream) {
        super(stream);
    }

    public void println(String x) {
        // do nothing
    }
}
