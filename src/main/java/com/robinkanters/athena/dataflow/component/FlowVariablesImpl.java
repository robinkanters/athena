package com.robinkanters.athena.dataflow.component;

import java.util.HashMap;

public class FlowVariablesImpl extends HashMap<String, String> implements FlowVariables {
    public String get(String key) throws NoSuchVariableException {
        return super.get(key);
    }

    public void set(String key, String value) {
        put(key, value);
    }

    public boolean has(String key) {
        return containsKey(key);
    }
}
