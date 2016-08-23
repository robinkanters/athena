package com.robinkanters.athena.datamapping;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VariableEvaluator implements Evaluator {
    private KeyValueStore variables;
    private String variablesPattern = ".*\\{(\\w+?)\\}.*";

    public VariableEvaluator(KeyValueStore keyValueStore) {
        this.variables = keyValueStore;
    }

    public String evaluate(String input) {
        if (input == null)
            return "";
        if (stringHasInterpolatedVariable(input))
            input = replaceVariables(input);
        return input;
    }

    private String replaceVariables(String input) {
        while (stringHasInterpolatedVariable(input)) {
            String variableName = getInterpolatedVariableName(input);
            input = input.replace(String.format("{%s}", variableName), getReplacement(variableName));
        }

        return input;
    }

    private String getInterpolatedVariableName(String input) {
        Pattern p = Pattern.compile(variablesPattern);
        Matcher matcher = p.matcher(input);
        //noinspection ResultOfMethodCallIgnored
        matcher.find();

        return matcher.group(1);
    }

    private String getReplacement(String variableName) {
        String replacement = variables.get(variableName);
        if (replacement == null)
            throw new VariableNotDefinedException();

        return replacement;
    }

    private boolean stringHasInterpolatedVariable(String input) {
        return input.matches(variablesPattern);
    }

    class VariableNotDefinedException extends RuntimeException {
        private VariableNotDefinedException() {
        }
    }
}
