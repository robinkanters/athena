package com.robinkanters.athena.dataflow.component.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class FileReaderImplTest {
    private String fileContents = "Foo";

    @Test
    public void read() throws Exception {
        FileReader fileReader = new FileReaderImpl() {
            protected String readFile(File f) throws IOException {
                return fileContents;
            }
        };

        assertEquals(fileContents, fileReader.read("some file"));
    }

    @Test(expected = FileReaderImpl.FileReaderException.class)
    public void read_WhenThrowsIOException_IsConvertedIntoRuntimeException() throws Exception {
        FileReader fileReader = new FileReaderImpl() {
            protected String readFile(File f) throws IOException {
                throw new IOException("test");
            }
        };

        assertEquals(fileContents, fileReader.read("some file"));
    }
}