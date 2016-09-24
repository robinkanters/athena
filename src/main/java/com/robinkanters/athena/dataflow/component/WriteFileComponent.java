package com.robinkanters.athena.dataflow.component;

import com.robinkanters.athena.dataflow.component.file.FileWriter;

public class WriteFileComponent implements FlowComponent {
    private final String fileName;
    private final FileWriter fileWriter;

    public WriteFileComponent(String fileName, FileWriter fileWriter) {
        this.fileName = fileName;
        this.fileWriter = fileWriter;
    }

    public String run(String payload, FlowVariables flowVariables) {
        fileWriter.write(fileName, payload);
        return payload;
    }
}
