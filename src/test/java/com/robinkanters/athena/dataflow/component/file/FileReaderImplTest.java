package com.robinkanters.athena.dataflow.component.file;

import com.robinkanters.athena.dataflow.component.file.exception.FileReaderException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class FileReaderImplTest {
    private String fileContents = "Foo";
    private FileReader fileReader;

    @Before
    public void setUp() throws Exception {
        fileReader = new FileReaderImpl() {
            protected String readFile(File f) throws IOException {
                return fileContents;
            }

            public String tryRead(String filename) throws IOException {
                if(filename.startsWith("throw"))
                    throw new IOException("test");
                return super.tryRead(filename);
            }
        };
    }

    @Test
    public void read() throws Exception {
        assertEquals(fileContents, fileReader.read("some file"));
    }

    @Test(expected = FileReaderException.class)
    public void read_WhenThrowsIOException_IsConvertedIntoRuntimeException() throws Exception {
        assertEquals(fileContents, fileReader.read("throw exception"));
    }
}