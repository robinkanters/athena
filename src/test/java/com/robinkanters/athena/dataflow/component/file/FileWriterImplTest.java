package com.robinkanters.athena.dataflow.component.file;

import com.robinkanters.athena.dataflow.component.file.exception.FileWriterException;
import com.robinkanters.athena.util.mock.FileWriterMock;
import org.junit.Before;
import org.junit.Test;

public class FileWriterImplTest {
    private String fileContents = "Foo";
    private FileWriterMock fileWriter;

    @Before
    public void setUp() throws Exception {
        fileWriter = new FileWriterMock();
    }

    @Test
    public void read() throws Exception {
        fileWriter.write("some file", fileContents);
        fileWriter.assertWriteCalled(1);
        fileWriter.assertWriteFileCalledWith(fileContents);
    }

    @Test(expected = FileWriterException.class)
    public void read_WhenThrowsIOException_IsConvertedIntoRuntimeException() throws Exception {
        fileWriter.write("throw exception", fileContents);
        fileWriter.assertWriteCalled(0);
    }

}