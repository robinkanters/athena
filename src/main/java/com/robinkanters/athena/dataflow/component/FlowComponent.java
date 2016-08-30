package com.robinkanters.athena.dataflow.component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@FlowComponent.DisplayName("")
public interface FlowComponent {
    String run(String payload);

    default String getDisplayName() {
        String displayName = getClass().getAnnotation(DisplayName.class).value();

        return displayName.equals("")
                ? getClass().getSimpleName()
                : displayName;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface DisplayName {
        String value();
    }
}
