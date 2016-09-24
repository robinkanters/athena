package com.robinkanters.athena.dataflow.component;

import com.robinkanters.athena.dataflow.Flow;
import com.robinkanters.athena.util.dummy.DummyFlowVariables;
import com.robinkanters.athena.util.spy.FlowComponentSpy;
import com.robinkanters.athena.util.stub.StubComponent;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SetPayloadComponentTest {
    private SetPayloadComponent setPayloadComponent;
    private String constructorPayload;
    private DummyFlowVariables variables;

    private void assertComponentReturns(String input, String expectedOutput) {
        assertComponentReturns(input, new FlowVariablesImpl(), expectedOutput);
    }

    private void assertComponentReturns(String input, FlowVariables variables, String expectedOutput) {
        assertEquals(expectedOutput, setPayloadComponent.run(input, variables));
    }

    @Before
    public void setUp() throws Exception {
        constructorPayload = "payload";
        setPayloadComponent = new SetPayloadComponent(constructorPayload);
        variables = new DummyFlowVariables();
    }

    @Test
    public void whenGivenNull_ReturnsPayloadFromConstructor() throws Exception {
        assertComponentReturns(null, constructorPayload);
        assertComponentReturns("", constructorPayload);
        assertComponentReturns("Foo", constructorPayload);
    }

    @Test
    public void whenComponentIncorporatedInFlow_ChangesPayloadMidFlow() throws Exception {
        Flow f = new Flow();
        f.addComponent(new StubComponent());
        f.addComponent(setPayloadComponent);

        FlowComponentSpy printStreamSpy = new FlowComponentSpy();
        f.addComponent(printStreamSpy);

        f.run("Foo", variables);

        assertEquals(constructorPayload, printStreamSpy.getIncomingPayload());
    }
}
