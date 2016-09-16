package com.robinkanters.athena.util.mock;

import com.robinkanters.athena.dataflow.component.file.FileWriterImpl;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileWriterMock extends FileWriterImpl {
    private String calledWriteWith;
    private int writeCalled = 0;

    protected void writeFile(File f, String contents) throws IOException {
        calledWriteWith = contents;
        writeCalled++;
    }

    public void assertWriteFileCalledWith(String expected) {
        assertEquals(expected, calledWriteWith);
    }

    public void assertWriteCalled(int expected) {
        assertEquals(expected, writeCalled);
    }

    public void tryWrite(String filename, String contents) throws IOException {
        if(filename.startsWith("throw"))
            throw new IOException("test");
        super.tryWrite(filename, contents);
    }
}
