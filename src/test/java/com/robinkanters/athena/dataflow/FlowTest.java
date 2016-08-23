package com.robinkanters.athena.dataflow;

import com.robinkanters.athena.dataflow.component.EchoComponent;
import com.robinkanters.athena.util.spy.PrintStreamSpy;
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
        assertEquals("", flow.run(null));
    }

    @Test
    public void passingEmptyStringIntoEmptyFlow_ReturnsEmptyString() throws Exception {
        assertEquals("", flow.run(""));
    }
    
    @Test
    public void passingNonEmptyStringIntoEmptyFlow_ReturnsThatStringUnmodified() throws Exception {
        assertEquals("Foo", flow.run("Foo"));
    }

    @Test
    public void flowWithEchoComponentReturnsStringEqualToInput() throws Exception {
        PrintStreamSpy spy = new PrintStreamSpy();

        flow.addComponent(new EchoComponent(spy));
        String output = flow.run("Foo");

        assertEquals("Foo", output);
        assertEquals("Foo\n", spy.getPrint());
    }
}
