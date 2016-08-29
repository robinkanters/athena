package com.robinkanters.athena.dataflow.component;

public class SetPayloadComponent implements FlowComponent {
    private final String payload;

    public SetPayloadComponent(String payload) {
        this.payload = payload;
    }

    public String run(String ignored) {
        return this.payload;
    }
}
