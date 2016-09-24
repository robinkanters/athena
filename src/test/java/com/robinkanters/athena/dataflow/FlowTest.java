package com.robinkanters.athena.dataflow;

import com.robinkanters.athena.dataflow.component.EchoComponent;
import com.robinkanters.athena.dataflow.component.FlowComponent;
import com.robinkanters.athena.dataflow.component.FlowVariables;
import com.robinkanters.athena.util.dummy.DummyFlowVariables;
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

    @Test
    public void canHaveSubFlows() {
        Flow subflow = new Flow();
        SpyComponent spyExpectsFoo = new SpyComponent();
        SpyComponent spyExpectsBar = new SpyComponent();

        flow.addComponent(subflow);
        subflow.addComponent(spyExpectsFoo);
        flow.addComponent(spyExpectsBar);

        String flowOutput = flow.run("foo");

        assertEquals("foo\n", spyExpectsFoo.getTrace());
        assertEquals("bar\n", spyExpectsBar.getTrace());
        assertEquals("bar", flowOutput);
    }

    private class SpyComponent implements FlowComponent {
        private String trace = "";

        public String run(String payload, FlowVariables flowVariables) {
            trace += payload;
            trace += "\n";

            return "bar";
        }

        String getTrace() {
            return trace;
        }
    }
}
