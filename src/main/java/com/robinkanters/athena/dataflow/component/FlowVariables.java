package com.robinkanters.athena.dataflow.component;

public interface FlowVariables {
    FlowVariables EMPTY = new FlowVariablesImpl();

    void set(String key, String value);

    boolean has(String key);

    String get(String key) throws NoSuchVariableException;

    void remove(String key) throws NoSuchVariableException;

    class NoSuchVariableException extends RuntimeException {
        protected NoSuchVariableException(String message) {
            super(message);
        }
    }
}
