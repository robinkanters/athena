package com.robinkanters.athena.util.mock;

import com.robinkanters.athena.dataflow.component.file.FileWriter;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MockFileWriter implements FileWriter {
    Map<String, String> files = new HashMap<>();
    int writeCalled = 0;

    public void write(String filename, String contents) {
        files.put(filename, contents);
        writeCalled++;
    }

    public String get(String filename) {
        return files.get(filename);
    }

    public void assertWriteCalled(int amount) {
        assertEquals(amount, writeCalled);
    }
}
