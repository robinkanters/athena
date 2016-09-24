package com.robinkanters.athena.dataflow.component;

import java.io.PrintStream;

@FlowComponent.DisplayName("Echo")
public class EchoComponent implements FlowComponent {
    private final PrintStream outputStream;

    public EchoComponent(PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    public String run(String payload, FlowVariables flowVariables) {
        outputStream.println(payload);
        return payload;
    }
}
