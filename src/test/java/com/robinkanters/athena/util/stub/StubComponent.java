package com.robinkanters.athena.util.stub;

import com.robinkanters.athena.dataflow.component.FlowComponent;
import com.robinkanters.athena.dataflow.component.FlowVariables;

public class StubComponent implements FlowComponent {
    public String run(String payload, FlowVariables flowVariables) {
        return payload;
    }
}
