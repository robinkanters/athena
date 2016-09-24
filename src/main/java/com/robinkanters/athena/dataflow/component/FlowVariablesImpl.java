package com.robinkanters.athena.dataflow.component;

import java.util.HashMap;

public class FlowVariablesImpl extends HashMap<String, String> implements FlowVariables {
    public void set(String key, String value) {
        put(key, value);
    }

    public String get(String key) throws NoSuchVariableException {
        throwIfNotExists(key);
        return super.get(key);
    }

    public boolean has(String key) {
        return containsKey(key);
    }

    public void remove(String key) throws NoSuchVariableException {
        throwIfNotExists(key);
        super.remove(key);
    }

    private void throwIfNotExists(String key) throws NoSuchVariableException {
        if(!has(key))
            throw new NoSuchVariableException(key);
    }
}
