package com.robinkanters.athena.dataflow.component;

import com.robinkanters.athena.dataflow.component.file.FileReader;

@SuppressWarnings("WeakerAccess")
public class FileComponent implements FlowComponent {
    private final FileReader fileReader;

    public FileComponent(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public String read(String fileName) {
        return fileReader.read(fileName);
    }

    public String run(String payload) {
        return read(payload);
    }
}
