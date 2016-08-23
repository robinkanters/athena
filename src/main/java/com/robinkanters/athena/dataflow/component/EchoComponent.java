package com.robinkanters.athena.dataflow.component;

import java.io.PrintStream;

public class EchoComponent {
    private final PrintStream outputStream;

    public EchoComponent() {
        this.outputStream = System.out;
    }

    public EchoComponent(PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    public String run(String payload) {
        outputStream.println(payload);
        return payload;
    }
}
