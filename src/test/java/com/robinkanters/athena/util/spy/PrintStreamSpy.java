package com.robinkanters.athena.util.spy;

import com.robinkanters.athena.util.dummy.DummyOutputStream;
import com.robinkanters.athena.util.dummy.DummyPrintStream;

public class PrintStreamSpy extends DummyPrintStream {
    private String print = "";

    public PrintStreamSpy() {
        super(new DummyOutputStream());
    }

    public void println(String x) {
        print += x;
        print += "\n";
    }

    public String getPrint() {
        return print;
    }
}
