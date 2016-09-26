package com.robinkanters.athena.dataflow.locator;

import com.robinkanters.athena.dataflow.component.FlowComponent;

import java.util.function.Supplier;

public interface ComponentFilter {
    boolean test(Supplier<? extends FlowComponent> c);
}
