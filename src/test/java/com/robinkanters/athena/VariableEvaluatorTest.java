package com.robinkanters.athena;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VariableEvaluatorTest {

    private VariableEvaluator variableEvaluator;
    private Variables variables;

    @Before
    public void setUp() throws Exception {
        variables = new Variables();
        variableEvaluator = new VariableEvaluator(variables);
    }

    @Test
    public void nullReturnsEmptyString() throws Exception {
        assertEquals("", variableEvaluator.evaluate(null));
    }
    
    @Test
    public void emptyStringReturnsEmptyString() throws Exception {
        assertEquals("", variableEvaluator.evaluate(""));
    }

    @Test
    public void stringWithoutVariablesIsReturnedTheSame() throws Exception {
        assertEquals("foo", variableEvaluator.evaluate("foo"));
    }

    @Test
    public void variableWithinCurlyBracesReturnsValueOfThatVariable() throws Exception {
        variables.put("variable", "bar");

        assertEquals("bar", variableEvaluator.evaluate("{variable}"));
        assertEquals("barbar", variableEvaluator.evaluate("{variable}{variable}"));
    }

    @Test(expected = VariableEvaluator.VariableNotDefinedException.class)
    public void usingAnUnknownVariable_ThrowsException() throws Exception {
        variableEvaluator.evaluate("{nonexistentVariable}");
    }
}
