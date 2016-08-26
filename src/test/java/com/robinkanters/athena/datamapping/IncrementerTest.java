package com.robinkanters.athena.datamapping;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IncrementerTest {
    private Incrementer incrementer;

    @Before
    public void setUp() throws Exception {
        incrementer = new Incrementer();
    }

    @Test
    public void valuesAreSequential() throws Exception {
        assertEquals(0, incrementer.getNextValue());
        assertEquals(1, incrementer.getNextValue());
    }

    @Test
    public void incrementerWithStartValueReturnsThatAsFirstValue() throws Exception {
        incrementer = new Incrementer(4);
        assertEquals(4, incrementer.getNextValue());
    }

    @Test
    public void incrementerWithStartValueReturnsIncrementalIntegers() throws Exception {
        incrementer = new Incrementer(2);
        assertEquals(2, incrementer.getNextValue());
        assertEquals(3, incrementer.getNextValue());
        assertEquals(4, incrementer.getNextValue());
    }

    @Test
    public void incrementerWithStepValueReturnsIntegersThatDifferByThatAmount() throws Exception {
        incrementer = new Incrementer(1, 2);
        assertEquals(1, incrementer.getNextValue());
        assertEquals(3, incrementer.getNextValue());
    }
}
