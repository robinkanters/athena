package com.robinkanters.athena.dataflow.component;

import com.robinkanters.athena.dataflow.Flow;
import com.robinkanters.athena.util.mock.MockFileReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileComponentTest {
    private FileComponent fileComponent;
    private MockFileReader mockFileReader;
    private String fileContents;
    private String fileName;

    @Before
    public void setUp() throws Exception {
        mockFileReader = new MockFileReader();
        fileComponent = new FileComponent(mockFileReader);

        fileContents = "Foobar";
        fileName = "/tmp/test.txt";
        mockFileReader.add(fileName, fileContents);
    }

    @Test
    public void canReadFile() throws Exception {
        String output = fileComponent.read(fileName);

        assertEquals(fileContents, output);
        mockFileReader.assertReadCalled(1);
    }

    @Test
    public void ifPayloadIsFileName_AfterComponentInvocation_PayloadIsFileContents() throws Exception {
        Flow flow = new Flow();
        flow.addComponent(fileComponent);

        String actualPayload = flow.run(fileName);

        assertEquals(fileContents, actualPayload);
        mockFileReader.assertReadCalled(1);
    }
}
