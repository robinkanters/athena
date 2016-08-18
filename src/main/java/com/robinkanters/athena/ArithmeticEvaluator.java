package com.robinkanters.athena;

import com.robinkanters.athena.format.DecimalFormatter;
import com.robinkanters.athena.math.*;

@SuppressWarnings("WeakerAccess")
public class ArithmeticEvaluator implements Evaluator {
    private String input;
    private Operation operation;
    private DecimalFormatter decimalFormatter = new DecimalFormatter();

    @SuppressWarnings("WeakerAccess")
    public String evaluate(String input) {
        this.input = input;
        if (hasAddition())
            return calculateAddition();
        else if(hasSubtraction())
            return calculateSubtraction();
        else if(hasMultiplication())
            return calculateMultiplication();
        else if (hasDivision())
            return calculateDivision();
        return input;
    }

    private boolean hasAddition() {
        return input.matches(".*\\d\\+\\d.*");
    }

    private boolean hasSubtraction() {
        return input.matches(".*\\d-\\d.*");
    }

    private boolean hasMultiplication() {
        return input.matches(".*\\d\\*\\d.*");
    }

    private boolean hasDivision() {
        return input.matches(".*\\d/\\d.*");
    }

    private String calculateAddition() {
        return calculateAndFormatResult(new AdditionOperation());
    }

    private String calculateSubtraction() {
        return calculateAndFormatResult(new SubtractionOperation());
    }

    private String calculateMultiplication() {
        return calculateAndFormatResult(new MultiplicationOperation());
    }

    private String calculateDivision() {
        return calculateAndFormatResult(new DivisionOperation());
    }

    private String calculateAndFormatResult(Operation operation) {
        return decimalFormatter.formatDouble(calculateResult(operation));
    }

    private double calculateResult(Operation operation) {
        this.operation = operation;
        return operation.calculate(Double.parseDouble(evaluateLeft()), Double.parseDouble(evaluateRight()));
    }

    private String evaluateNested(String operation) {
        return new ArithmeticEvaluator().evaluate(operation);
    }

    private String evaluateLeft() {
        String expression = input.substring(0, input.indexOf(getOperand()));
        return evaluateNested(expression);
    }

    private String evaluateRight() {
        String expression = input.substring(input.indexOf(getOperand()) + 1);
        return evaluateNested(expression);
    }

    private char getOperand() {
        return operation.getSymbol();
    }
}
