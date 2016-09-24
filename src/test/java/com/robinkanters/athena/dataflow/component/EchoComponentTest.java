package com.robinkanters.athena.dataflow.component;

import com.robinkanters.athena.util.dummy.DummyFlowVariables;
import com.robinkanters.athena.util.spy.PrintStreamSpy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EchoComponentTest {
    private EchoComponent flowComponent;
    private PrintStreamSpy spy;
    private FlowVariables variables;

    @Before
    public void setUp() throws Exception {
        spy = new PrintStreamSpy();
        flowComponent = new EchoComponent(spy);
        variables = new DummyFlowVariables();
    }

    @Test
    public void runReturnsInputAsOutput() throws Exception {
        assertEquals("Foo", flowComponent.run("Foo", variables));
    }

    @Test
    public void runPrintsPayloadToOutput() throws Exception {
        flowComponent.run("Foo", variables);

        assertEquals("Foo\n", spy.getPrint());
    }

    @Test
    public void canGetDisplayName() throws Exception {
        String displayName = flowComponent.getClass().getAnnotation(FlowComponent.DisplayName.class).value();
        assertEquals(displayName, flowComponent.getDisplayName());
    }
}
