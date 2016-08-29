package com.robinkanters.athena.dataflow.component.file;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class FileReaderImplTest {

    private FileReaderImpl fileReader;
    private String fileContents = "Foo";

    @Before
    public void setUp() throws Exception {
        fileReader = new FileReaderImpl() {
            protected String readFile(File f) throws IOException {
                return fileContents;
            }
        };
    }

    @Test
    public void read() throws Exception {
        assertEquals(fileContents, fileReader.read("some file"));
    }
}