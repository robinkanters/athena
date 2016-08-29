package com.robinkanters.athena.util.spy;

import com.robinkanters.athena.dataflow.component.FlowComponent;

public class FlowComponentSpy implements FlowComponent {
    private String incomingPayload;

    public String run(String payload) {
        this.incomingPayload = payload;
        return payload;
    }

    public String getIncomingPayload() {
        return incomingPayload;
    }
}
