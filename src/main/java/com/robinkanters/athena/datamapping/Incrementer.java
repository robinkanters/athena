package com.robinkanters.athena.datamapping;

public class Incrementer implements ValueGenerator {
    private final int step;
    private int value;

    public Incrementer() {
        step = 1;
    }

    public Incrementer(int start) {
        value = start;
        step = 1;
    }

    public Incrementer(int start, int step) {
        value = start;
        this.step = step;
    }

    public int getNextValue() {
        int result = value;
        value += step;

        return result;
    }
}
