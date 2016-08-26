package com.robinkanters.athena.testutil.testdoubles.spies;

import com.robinkanters.athena.testutil.testdoubles.dummies.DummyOutputStream;

import java.io.PrintStream;

public class PrintStreamSpy extends PrintStream {
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
