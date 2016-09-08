package com.robinkanters.athena.dataflow.locator;

import com.robinkanters.athena.dataflow.component.FlowComponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

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
        return stream(filters).allMatch(f -> f.test(c));
    }

    public void add(FlowComponent component) {
        if (components.contains(component))
            return;

        components.add(component);
    }
}
