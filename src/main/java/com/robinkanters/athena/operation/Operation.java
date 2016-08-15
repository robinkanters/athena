package com.robinkanters.athena.operation;

public interface Operation {
    char getSymbol();
    double calculate(double left, double right);
}
