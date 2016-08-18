package com.robinkanters.athena.math;

public interface Operation {
    char getSymbol();
    double calculate(double left, double right);
}
