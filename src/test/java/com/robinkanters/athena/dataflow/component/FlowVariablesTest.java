package com.robinkanters.athena.dataflow.component;

import com.robinkanters.athena.dataflow.component.FlowVariables.NoSuchVariableException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlowVariablesTest {
    private FlowVariables flowVariables;

    private static final String KEY = "key";
    private static final String VALUE = "value";

    @Before
    public void setUp() throws Exception {
        flowVariables = new FlowVariablesImpl();
    }

    @Test
    public void beforeSet_HasReturnsFalse() throws Exception {
        assertFalse(flowVariables.has(KEY));
    }

    @Test(expected = NoSuchVariableException.class)
    public void beforeSet_GetThrowsException() throws Exception {
        flowVariables.get(KEY);
    }

    @Test(expected = NoSuchVariableException.class)
    public void beforeSet_RemoveThrowsException() throws Exception {
        flowVariables.remove(KEY);
    }
    
    @Test
    public void afterSet_GetReturnsOriginalValue() throws Exception {
        flowVariables.set(KEY, VALUE);

        assertTrue(flowVariables.has(KEY));
        assertEquals(VALUE, flowVariables.get(KEY));
    }

    @Test
    public void afterSetAndRemove_HasReturnsFalse() throws Exception {
        flowVariables.set(KEY, VALUE);
        flowVariables.remove(KEY);

        assertFalse(flowVariables.has(KEY));
    }

    @Test
    public void afterSetX_YIsNotSet() throws Exception {
        flowVariables.set(KEY, VALUE);

        assertTrue(flowVariables.has(KEY));
        assertFalse(flowVariables.has("Y"));
    }
}