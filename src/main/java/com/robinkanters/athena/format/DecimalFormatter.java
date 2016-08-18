package com.robinkanters.athena.format;

public class DecimalFormatter {
    public String formatDouble(double calculatedResult) {
        if(canBeCastToLong(calculatedResult))
            return formatLong(calculatedResult);

        return String.format("%f", calculatedResult);
    }

    private boolean canBeCastToLong(double calculatedResult) {
        return calculatedResult == (long)calculatedResult;
    }

    public String formatLong(double number) {
        return formatLong((long)number);
    }

    public String formatLong(long calculatedResult) {
        return String.format("%d", calculatedResult);
    }
}
