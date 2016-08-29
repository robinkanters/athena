package com.robinkanters.athena.util.stub;

import com.robinkanters.athena.dataflow.component.FlowComponent;

public class StubComponent implements FlowComponent {
    public String run(String payload) {
        return payload;
    }
}
