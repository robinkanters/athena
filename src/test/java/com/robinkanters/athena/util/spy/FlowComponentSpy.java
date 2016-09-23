package com.robinkanters.athena.util.spy;

import com.robinkanters.athena.dataflow.component.FlowComponent;
import com.robinkanters.athena.dataflow.component.FlowVariables;

public class FlowComponentSpy implements FlowComponent {
    private String incomingPayload;

    public String run(String payload, FlowVariables flowVariables) {
        this.incomingPayload = payload;
        return payload;
    }

    public String getIncomingPayload() {
        return incomingPayload;
    }
}
