package com.robinkanters.athena.util.mock;

import com.robinkanters.athena.dataflow.component.file.FileReader;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MockFileReader implements FileReader {
    Map<String, String> files = new HashMap<>();
    int readCalled = 0;

    public String read(String filename) {
        readCalled++;
        return files.get(filename);
    }

    public void add(String filename, String contents) {
        files.put(filename, contents);
    }

    public void assertReadCalled(int amount) {
        assertEquals(amount, readCalled);
    }
}
