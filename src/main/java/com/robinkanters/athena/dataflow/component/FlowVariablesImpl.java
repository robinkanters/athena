package com.robinkanters.athena.dataflow.component;

import java.util.HashMap;

public class FlowVariablesImpl extends HashMap<String, String> implements FlowVariables {
    public String get(String key) {
        return get(key);
    }

    public void set(String key, String value) {
        put(key, value);
    }
}
