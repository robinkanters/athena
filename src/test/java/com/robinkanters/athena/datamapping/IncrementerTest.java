package com.robinkanters.athena.datamapping;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IncrementerTest {
    private Incrementer incrementer;

    private void assertNextValueIs(int expected) {
        assertEquals(expected, incrementer.getNextValue());
    }

    @Before
    public void setUp() throws Exception {
        incrementer = new Incrementer();
    }

    @Test
    public void valuesAreSequential() throws Exception {
        assertNextValueIs(0);
        assertNextValueIs(1);
    }

    @Test
    public void incrementerWithStartValueReturnsThatAsFirstValue() throws Exception {
        incrementer = new Incrementer(4);
        assertNextValueIs(4);
    }

    @Test
    public void incrementerWithStartValueReturnsIncrementalIntegers() throws Exception {
        incrementer = new Incrementer(2);
        assertNextValueIs(2);
        assertNextValueIs(3);
        assertNextValueIs(4);
    }

    @Test
    public void incrementerWithStepValueReturnsIntegersThatDifferByThatAmount() throws Exception {
        incrementer = new Incrementer(1, 2);
        assertNextValueIs(1);
        assertNextValueIs(3);
    }

    @Test
    public void greaterStartValue() throws Exception {
        incrementer = new Incrementer(10, 2);
        assertNextValueIs(10);
        assertNextValueIs(12);
    }

    @Test
    public void greaterStepValue() throws Exception {
        incrementer = new Incrementer(4, 5);
        assertNextValueIs(4);
        assertNextValueIs(9);
    }
}
