package com.robinkanters.athena.format;

import java.text.DecimalFormat;

public class DecimalFormatter {
    public String format(double input) {
        if (canBeCastToLong(input))
            return format((long) input);

        return formatDouble(input);
    }

    public String format(long input) {
        return formatDouble(input);
    }

    private String formatDouble(double input) {
        DecimalFormat df = new DecimalFormat("0.########");
        return df.format(input);
    }

    private boolean canBeCastToLong(double calculatedResult) {
        return calculatedResult == (long) calculatedResult;
    }
}
