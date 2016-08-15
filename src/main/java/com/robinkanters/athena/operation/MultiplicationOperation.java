package com.robinkanters.athena.operation;

public class MultiplicationOperation implements Operation {
    public char getSymbol() {
        return '*';
    }

    public double calculate(double left, double right) {
        return left * right;
    }
}
