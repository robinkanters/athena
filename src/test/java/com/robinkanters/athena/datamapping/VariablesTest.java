package com.robinkanters.athena.datamapping;

import com.robinkanters.athena.format.DecimalFormatter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VariablesTest {
    private Variables variables;
    private DecimalFormatterSpy decimalFormatterSpy;

    @Before
    public void setUp() throws Exception {
        decimalFormatterSpy = new DecimalFormatterSpy();
        variables = new Variables(decimalFormatterSpy);
    }

    @Test
    public void put_Integer() throws Exception {
        variables.put("Foo", 1);

        assertEquals("1", variables.get("Foo"));

        decimalFormatterSpy.assertFormatDoubleCalled(0);
        decimalFormatterSpy.assertFormatLongCalled(0);
    }

    @Test
    public void put_Long_NoDecimals() throws Exception {
        variables.put("Foo", 1L);

        assertEquals("1", variables.get("Foo"));

        decimalFormatterSpy.assertFormatDoubleCalled(0);
        decimalFormatterSpy.assertFormatLongCalled(1);
    }

    @Test
    public void put_Double_WithoutDecimals_FormatedAsLong() throws Exception {
        variables.put("Foo", 1.0);

        assertEquals("1", variables.get("Foo"));

        decimalFormatterSpy.assertFormatDoubleCalled(1);
        decimalFormatterSpy.assertFormatLongCalled(1);
    }

    @Test
    public void put_Double_WithDecimals() throws Exception {
        variables.put("Foo", 1.1);

        assertEquals("1.1", variables.get("Foo"));

        decimalFormatterSpy.assertFormatDoubleCalled(1);
        decimalFormatterSpy.assertFormatLongCalled(0);
    }

    private class DecimalFormatterSpy extends DecimalFormatter {
        private int formatDoubleCalled = 0;
        private int formatLongCalled = 0;

        public String format(double input) {
            formatDoubleCalled++;
            return super.format(input);
        }

        public String format(long input) {
            formatLongCalled++;
            return super.format(input);
        }

        void assertFormatDoubleCalled(int times) {
            assertEquals(times, formatDoubleCalled);
        }

        void assertFormatLongCalled(int times) {
            assertEquals(times, formatLongCalled);
        }
    }
}
