package com.robinkanters.athena.dataflow.component;

public interface FlowVariables {
    FlowVariables EMPTY = new FlowVariablesImpl();

    String get(String key) throws NoSuchVariableException;

    void set(String key, String value);

    boolean has(String key);

    class NoSuchVariableException extends RuntimeException {
        protected NoSuchVariableException(String message) {
            super(message);
        }

        protected NoSuchVariableException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
