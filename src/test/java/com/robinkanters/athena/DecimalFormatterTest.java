package com.robinkanters.athena;

import com.robinkanters.athena.format.DecimalFormatter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DecimalFormatterTest {

    private DecimalFormatter formatter;

    @Before
    public void setUp() throws Exception {
        formatter = new DecimalFormatter();
    }

    @Test
    public void formatSimpleDouble() throws Exception {
        assertFormatsAs(1.0, "1");
    }

    private void assertFormatsAs(double input, String expected) {
        assertEquals(expected, formatter.format(input));
    }

    @Test
    public void formatDoubleWithNonZeroDecimals() throws Exception {
        assertFormatsAs(1.1, "1.1");
        assertFormatsAs(1.12, "1.12");
        assertFormatsAs(1.123, "1.123");
        assertFormatsAs(1.1234, "1.1234");
        assertFormatsAs(1.12345, "1.12345");
        assertFormatsAs(1.123456, "1.123456");
        assertFormatsAs(1.1234567, "1.1234567");
        assertFormatsAs(1.12345678, "1.12345678");

        String roundedDown = "1.12345678";
        assertFormatsAs(1.123456785, roundedDown);

        String roundedUp = "1.12345679";
        assertFormatsAs(1.123456786, roundedUp);
    }

    @Test
    public void formatLong() throws Exception {
        assertEquals("1", formatter.format((long) 1));
        assertEquals("10", formatter.format((long) 10));
    }
}
