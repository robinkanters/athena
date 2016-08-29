package com.robinkanters.athena.dataflow.locator;

import com.robinkanters.athena.dataflow.component.FlowComponent;

import java.util.ArrayList;
import java.util.List;

public class FlowComponentLocatorImpl implements ComponentLocator {
    private List<FlowComponent> components = new ArrayList<>();

    public List<FlowComponent> all() {
        return new ArrayList<>(components);
    }

    public List<FlowComponent> filter(ComponentFilter... filters) {
        return filterComponents(all(), filters);
    }

    public void register(FlowComponent component) {
        if(components.contains(component))
            return;

        components.add(component);
    }

    private List<FlowComponent> filterComponents(List<FlowComponent> components, ComponentFilter... filters) {
        components = new ArrayList<>(components);

        for(ComponentFilter filter : filters)
            for(FlowComponent c : components)
                if(!filter.isCompliant(c))
                    components.remove(c);

        return components;
    }
}
