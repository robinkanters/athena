package com.robinkanters.athena.datamapping;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArithmeticEvaluatorTest {

    private ArithmeticEvaluator arithmeticEvaluator;

    @Before
    public void setUp() throws Exception {
        arithmeticEvaluator = new ArithmeticEvaluator();
    }

    private void assertEvaluates(String operation, String expectation) {
        assertEquals(expectation, arithmeticEvaluator.evaluate(operation));
    }

    @Test
    public void ifPassedASimpleNumber_ReturnsThatNumber() throws Exception {
        assertEvaluates("1", "1");
        assertEvaluates("2", "2");
    }

    @Test
    public void onePlusTwoReturnsThree() throws Exception {
        assertEvaluates("1+2", "3");
    }

    @Test
    public void twelveMinusNineIsThree() throws Exception {
        assertEvaluates("12-9", "3");
    }

    @Test
    public void twoTimesFourIsEight() throws Exception {
        assertEvaluates("2*4", "8");
    }

    @Test
    public void twoTimesThreePlusFourIsTen() throws Exception {
        assertEvaluates("2*3+4", "10");
    }

    @Test
    public void sixOverTwoIsThree() throws Exception {
        assertEvaluates("6/2", "3");
    }

    @Test
    public void eightOverTwoTimesThreeIsTwelve() throws Exception {
        assertEvaluates("8/2*3", "12");
    }

    @Ignore
    @Test
    public void twoToPowerThreeIsEight() throws Exception {
        assertEvaluates("2^3", "8");
    }

    @Ignore
    @Test
    public void sixPlusTwoToPowerTwoIsTen() throws Exception {
        assertEvaluates("6+2^2", "10");
    }

    @Ignore
    @Test
    public void tenToPowerMinusTwoIsOneHundredth() throws Exception {
        assertEvaluates("10^-2", "0.01");
    }
}
