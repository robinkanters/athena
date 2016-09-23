package com.robinkanters.athena.dataflow.component;

import com.robinkanters.athena.dataflow.Flow;
import com.robinkanters.athena.util.dummy.DummyFlowVariables;
import com.robinkanters.athena.util.mock.MockFileWriter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileWriteComponentTest {
    private MockFileWriter mockFileWriter;
    private WriteFileComponent writeFileComponent;
    private String fileContents;
    private String fileName;
    private DummyFlowVariables variables;

    @Before
    public void setUp() throws Exception {
        mockFileWriter = new MockFileWriter();

        fileContents = "Foobar";
        fileName = "/tmp/test.txt";

        writeFileComponent = new WriteFileComponent(fileName, mockFileWriter);
        variables = new DummyFlowVariables();
    }

    @Test
    public void canWriteFile() throws Exception {
        String returnedPayload = writeFileComponent.run(fileContents, variables);

        mockFileWriter.assertWriteCalled(1);
        assertEquals(fileContents, returnedPayload);
        assertEquals(fileContents, mockFileWriter.get(fileName));
    }

    @Test
    public void ifPayloadIsFileName_AfterComponentInvocation_PayloadIsFileContents() throws Exception {
        Flow flow = new Flow();
        flow.addComponent(writeFileComponent);

        String actualPayload = flow.run(fileContents, variables);

        assertEquals(fileContents, actualPayload);
        mockFileWriter.assertWriteCalled(1);
    }
}
