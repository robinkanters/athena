package com.robinkanters.athena.dataflow.component;

import com.robinkanters.athena.dataflow.component.file.FileReader;

@SuppressWarnings("WeakerAccess")
@FlowComponent.DisplayName("Read file")
public class ReadFileComponent implements FlowComponent {
    private final FileReader fileReader;

    public ReadFileComponent(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public String read(String fileName) {
        return fileReader.read(fileName);
    }

    public String run(String payload) {
        return read(payload);
    }
}
