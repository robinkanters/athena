package com.robinkanters.athena.dataflow.locator;

import com.robinkanters.athena.dataflow.component.FlowComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlowComponentLocatorImpl implements ComponentLocator {
    private List<FlowComponent> components = new ArrayList<>();

    public List<FlowComponent> all() {
        return new ArrayList<>(components);
    }

    public List<FlowComponent> filter(ComponentFilter... filters) {
        return all()
                .stream()
                .filter(c -> componentCompliesToAllFilters(c, filters))
                .collect(Collectors.toList());
    }

    private boolean componentCompliesToAllFilters(FlowComponent c, ComponentFilter[] filters) {
        for (ComponentFilter filter : filters)
            if (!filter.test(c))
                return false;
        return true;
    }

    public void add(FlowComponent component) {
        if (components.contains(component))
            return;

        components.add(component);
    }
}
