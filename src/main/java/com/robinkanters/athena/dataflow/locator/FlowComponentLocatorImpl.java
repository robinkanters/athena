package com.robinkanters.athena.dataflow.locator;

import com.robinkanters.athena.dataflow.component.FlowComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class FlowComponentLocatorImpl implements ComponentLocator {
    private List<Supplier<? extends FlowComponent>> components = new ArrayList<>();

    public List<Supplier<? extends FlowComponent>> all() {
        return new ArrayList<>(components);
    }

    public List<Supplier<? extends FlowComponent>> filter(ComponentFilter... filters) {
        return all()
                .stream()
                .filter(c -> componentCompliesToAllFilters(c, filters))
                .collect(Collectors.toList());
    }

    private boolean componentCompliesToAllFilters(Supplier<? extends FlowComponent> c, ComponentFilter[] filters) {
        return stream(filters).allMatch(f -> test(c, f));
    }

    private boolean test(Supplier<? extends FlowComponent> componentSupplier, ComponentFilter filter) {
        return filter.test(componentSupplier);
    }

    public void add(Supplier<? extends FlowComponent> component) {
        if (components.contains(component))
            return;

        components.add(component);
    }
}
