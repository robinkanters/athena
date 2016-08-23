package com.robinkanters.athena.dataflow;

import com.robinkanters.athena.dataflow.component.FlowComponent;

import java.util.ArrayList;
import java.util.List;

public class Flow {
    private List<FlowComponent> components = new ArrayList<FlowComponent>();

    public synchronized String run(String payload) {
        if(payload == null)
            payload = "";

        for (FlowComponent component : components) {
            payload = component.run(payload);
        }

        return payload;
    }

    public void addComponent(FlowComponent flowComponent) {
        components.add(flowComponent);
    }
}
