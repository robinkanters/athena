package com.robinkanters.athena.dataflow.locator;

import com.robinkanters.athena.dataflow.component.FlowComponent;

import java.util.List;

public interface ComponentLocator {
    List<FlowComponent> all();

    List<FlowComponent> filter(ComponentFilter... filters);

    void add(FlowComponent component);
}
