package com.robinkanters.athena.util.dummy;

import com.robinkanters.athena.dataflow.component.FlowVariables;

public class DummyFlowVariables implements FlowVariables {
    public String get(String key) {
        return null;
    }

    public void set(String key, String value) {
        // do nothing
    }
}
