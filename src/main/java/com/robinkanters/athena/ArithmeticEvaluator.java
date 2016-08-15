package com.robinkanters.athena;

import com.robinkanters.athena.operation.*;

@SuppressWarnings("WeakerAccess")
public class ArithmeticEvaluator {
    private String input;
    private Operation operation;

    @SuppressWarnings("WeakerAccess")
    public double evaluate(String input) {
        this.input = input;
        if (!hasAddition())
            return calculateAddition();
        else if(hasSubtraction())
            return calculateSubtraction();
        else if(hasMultiplication())
            return calculateMultiplication();
        else if (hasDivision())
            return calculateDivision();
        else
            return Integer.parseInt(input);
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

    private double calculateAddition() {
        return calculateResult(new AdditionOperation());
    }

    private double calculateSubtraction() {
        return calculateResult(new SubtractionOperation());
    }

    private double calculateMultiplication() {
        return calculateResult(new MultiplicationOperation());
    }

    private double calculateDivision() {
        return calculateResult(new DivisionOperation());
    }

    private double calculateResult(Operation operation) {
        this.operation = operation;
        return operation.calculate(evaluateLeft(), evaluateRight());
    }

    private double evaluateNested(String operation) {
        return new ArithmeticEvaluator().evaluate(operation);
    }

    private double evaluateLeft() {
        String expression = input.substring(0, input.indexOf(getOperand()));
        return evaluateNested(expression);
    }

    private double evaluateRight() {
        String expression = input.substring(input.indexOf(getOperand()) + 1);
        return evaluateNested(expression);
    }

    private char getOperand() {
        return operation.getSymbol();
    }
}
