package com.robinkanters.athena.dataflow.component;

public interface FlowVariables {
    String get(String key);

    void set(String key, String value);
}
