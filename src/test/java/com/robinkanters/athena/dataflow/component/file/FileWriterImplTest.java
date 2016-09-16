package com.robinkanters.athena.dataflow.component.file;

import com.robinkanters.athena.dataflow.component.file.exception.FileReaderException;
import com.robinkanters.athena.dataflow.component.file.exception.FileWriterException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileWriterImplTest {
    private String fileContents = "Foo";
    private FileWriter fileWriter;

    @Before
    public void setUp() throws Exception {
        fileWriter = new FileWriterImpl() {
            protected void writeFile(File f, String contents) throws IOException {
                assertEquals(fileContents, contents);
            }

            public void tryWrite(String filename, String contents) throws IOException {
                if(filename.startsWith("throw"))
                    throw new IOException("test");
                super.tryWrite(filename, contents);
            }
        };
    }

    @Test
    public void read() throws Exception {
        fileWriter.write("some file", fileContents);
    }

    @Test(expected = FileWriterException.class)
    public void read_WhenThrowsIOException_IsConvertedIntoRuntimeException() throws Exception {
        fileWriter.write("throw exception", fileContents);
    }
}