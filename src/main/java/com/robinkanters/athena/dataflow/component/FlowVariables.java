package com.robinkanters.athena.dataflow.component;

public interface FlowVariables {
    FlowVariables EMPTY = new FlowVariablesImpl();

    String get(String key);

    void set(String key, String value);
}
