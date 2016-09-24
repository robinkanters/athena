package com.robinkanters.athena.dataflow.component;

@FlowComponent.DisplayName("Set payload")
public class SetPayloadComponent implements FlowComponent {
    private final String payload;

    public SetPayloadComponent(String payload) {
        this.payload = payload;
    }

    public String run(String ignored, FlowVariables flowVariables) {
        return this.payload;
    }
}
