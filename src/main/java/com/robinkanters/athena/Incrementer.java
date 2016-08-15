package com.robinkanters.athena;

public class Incrementer implements ValueGenerator {
    private int value;
    private final int step;

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
