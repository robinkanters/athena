package com.robinkanters.athena.dataflow;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlowTest {
    private Flow flow;

    @Before
    public void setUp() throws Exception {
        flow = new Flow();
    }

    @Test
    public void passingNullIntoEmptyFlow_ReturnsEmptyString() throws Exception {
        flow.setPayload(null);
        flow.run();
        assertEquals("", flow.getPayload());
    }

    @Test
    public void passingEmptyStringIntoEmptyFlow_ReturnsEmptyString() throws Exception {
        flow.setPayload("");
        flow.run();
        assertEquals("", flow.getPayload());
    }
    
    @Test
    public void passingNonEmptyStringIntoEmptyFlow_ReturnsThatStringUnmodified() throws Exception {
        flow.setPayload("Foo");
        flow.run();
        assertEquals("Foo", flow.getPayload());
    }
}
