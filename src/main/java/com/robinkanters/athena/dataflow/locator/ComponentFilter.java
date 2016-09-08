package com.robinkanters.athena.dataflow.locator;

import com.robinkanters.athena.dataflow.component.FlowComponent;

public interface ComponentFilter {
    boolean test(FlowComponent c);
}
