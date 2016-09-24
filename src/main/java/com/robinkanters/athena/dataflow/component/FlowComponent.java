package com.robinkanters.athena.dataflow.component;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@FlowComponent.DisplayName("")
public interface FlowComponent {
    String run(String payload, FlowVariables flowVariables);

    default String getDisplayName() {
        final DisplayName annotation = getClass().getAnnotation(DisplayName.class);

        return annotation != null
                ? annotation.value()
                : getClass().getSimpleName();
    }

    @Retention(RUNTIME)
    @interface DisplayName {
        String value();
    }
}
