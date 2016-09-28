package com.robinkanters.athena.math;

public class ExponentiationOperation implements Operation {
    public char getSymbol() {
        return '^';
    }

    public double calculate(double left, double right) {
        return Math.pow(left, right);
    }
}
