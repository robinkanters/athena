package com.robinkanters.athena.datamapping;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VariableEvaluatorTest {

    private VariableEvaluator variableEvaluator;
    private Variables variables;

    private void assertEvaluatesAs(String input, String expected) {
        assertEquals(expected, variableEvaluator.evaluate(input));
    }

    @Before
    public void setUp() throws Exception {
        variables = new Variables();
        variableEvaluator = new VariableEvaluator(variables);
    }

    @Test
    public void nullReturnsEmptyString() throws Exception {
        assertEvaluatesAs(null, "");
    }

    @Test
    public void emptyStringReturnsEmptyString() throws Exception {
        assertEvaluatesAs("", "");
    }

    @Test
    public void stringWithoutVariablesIsReturnedTheSame() throws Exception {
        assertEvaluatesAs("foo", "foo");
    }

    @Test
    public void variableWithinCurlyBracesReturnsValueOfThatVariable() throws Exception {
        variables.put("variable", "bar");

        assertEvaluatesAs("{variable}", "bar");
        assertEvaluatesAs("{variable}{variable}", "barbar");
    }

    @Test(expected = VariableEvaluator.VariableNotDefinedException.class)
    public void usingAnUnknownVariable_ThrowsException() throws Exception {
        variableEvaluator.evaluate("{nonexistentVariable}");
    }
}
