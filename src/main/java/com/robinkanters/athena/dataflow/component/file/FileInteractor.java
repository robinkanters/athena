package com.robinkanters.athena.dataflow.component.file;

import java.io.File;

public class FileInteractor {
    protected File getFileForFilename(String filename) {
        return new File(filename);
    }
}
