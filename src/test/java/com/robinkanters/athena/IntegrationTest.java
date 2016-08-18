package com.robinkanters.athena;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegrationTest {
    private ArithmeticEvaluator arithmeticEvaluator;
    private VariableEvaluator variableEvaluator;

    @Before
    public void setUp() throws Exception {
        arithmeticEvaluator = new ArithmeticEvaluator();

        Variables variables = new Variables();
        variables.put("var1", 1);
        variables.put("var2", 2);
        variableEvaluator = new VariableEvaluator(variables);
    }

    @Test
    public void variablesAndArithmetic() throws Exception {
        assertEvaluates("{var1}+{var2}", "3");
    }

    private void assertEvaluates(String input, String expectedOutput) {
        String actualResult = arithmeticEvaluator.evaluate(variableEvaluator.evaluate(input));
        assertEquals(expectedOutput, actualResult);
    }
}
