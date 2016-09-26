package com.robinkanters.athena.dataflow.locator;

import com.robinkanters.athena.dataflow.component.FlowComponent;

import java.util.List;
import java.util.function.Supplier;

public interface ComponentLocator {
    List<Supplier<? extends FlowComponent>> all();

    List<Supplier<? extends FlowComponent>> filter(ComponentFilter... filters);

    void add(Supplier<? extends FlowComponent> component);
}
