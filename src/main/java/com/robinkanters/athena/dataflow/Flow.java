package com.robinkanters.athena.dataflow;

import com.robinkanters.athena.dataflow.component.FlowComponent;

import java.util.ArrayList;
import java.util.List;

public class Flow implements FlowComponent {
    private List<FlowComponent> components = new ArrayList<>();
    private String displayName;

    public synchronized String run(String payload) {
        if (payload == null)
            payload = "";

        for (FlowComponent component : components) {
            payload = component.run(payload);
        }

        return payload;
    }

    public String getDisplayName() {
        return displayNameIsSet()
                ? displayName
                : FlowComponent.super.getDisplayName();
    }

    private boolean displayNameIsSet() {
        return displayName != null && !displayName.isEmpty();
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void addComponent(FlowComponent flowComponent) {
        components.add(flowComponent);
    }
}
