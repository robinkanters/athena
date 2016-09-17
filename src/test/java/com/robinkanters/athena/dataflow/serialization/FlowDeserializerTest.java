package com.robinkanters.athena.dataflow.serialization;

import com.robinkanters.athena.dataflow.Flow;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlowDeserializerTest {
    private FlowDeserializer flowDeserializer;

    @Before
    public void setUp() throws Exception {
        flowDeserializer = new FlowDeserializer();
    }

    @Test
    public void returnsEmptyFlowWhenNoDataGiven() throws Exception {
        assertDeserializedNotNull(null);
        assertDeserializedNotNull("");
        assertDeserializedNotNull("{}");
    }

    @Test
    public void assertEmptyFlowHasDefaultName() throws Exception {
        Flow f = flowDeserializer.deserialize((String)null);
        assertEquals(new Flow().getDisplayName(), f.getDisplayName());
    }

    @Test
    public void flowHasNameWhenNameGivenInSerializedData() throws Exception {
        Flow f = flowDeserializer.deserialize("{'name':'Foo'}".replace('\'', '"'));
        assertEquals("Foo", f.getDisplayName());
    }

    private void assertDeserializedNotNull(String serialized) {
        assertNotNull(flowDeserializer.deserialize(serialized));
    }
}
