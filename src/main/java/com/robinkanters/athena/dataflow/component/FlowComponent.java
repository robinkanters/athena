package com.robinkanters.athena.dataflow.component;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@FlowComponent.DisplayName("")
public interface FlowComponent {
    String run(String payload, FlowVariables flowVariables);

    default String getDisplayName() {
        final DisplayName annotation = getClass().getAnnotation(DisplayName.class);
        String displayName = annotation != null ? annotation.value() : "";

        return displayName.isEmpty()
                ? getClass().getSimpleName()
                : displayName;
    }

    @Retention(RUNTIME)
    @interface DisplayName {
        String value();
    }
}
