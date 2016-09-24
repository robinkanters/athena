package com.robinkanters.athena.util.dummy;

import com.robinkanters.athena.dataflow.component.FlowComponent;
import com.robinkanters.athena.dataflow.component.FlowVariables;

public class DummyFlowComponent implements FlowComponent {
    public String run(String payload, FlowVariables flowVariables) {
        return null;
    }
}
