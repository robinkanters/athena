package com.robinkanters.athena.dataflow;

import com.robinkanters.athena.dataflow.component.FlowComponent;
import com.robinkanters.athena.dataflow.component.FlowVariables;

import java.util.ArrayList;
import java.util.List;

import static com.robinkanters.athena.dataflow.component.FlowVariables.EMPTY;

public class Flow implements FlowComponent {
    protected List<FlowComponent> components = new ArrayList<>();

    public String run(String payload) {
        return run(payload, EMPTY);
    }

    public String run(String payload, FlowVariables variables) {
        if (payload == null)
            payload = "";

        for (FlowComponent component : components)
            payload = component.run(payload, variables);

        return payload;
    }

    public void addComponent(FlowComponent flowComponent) {
        components.add(flowComponent);
    }
}
