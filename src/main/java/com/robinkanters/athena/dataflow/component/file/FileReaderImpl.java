package com.robinkanters.athena.dataflow.component.file;

import com.robinkanters.athena.dataflow.component.file.exception.FileReaderException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileReaderImpl extends FileInteractor implements FileReader {
    public String read(String filename) {
        try {
            return tryRead(filename);
        } catch (IOException e) {
            throw new FileReaderException(e);
        }
    }

    protected String tryRead(String filename) throws IOException {
        File f = getFileForFilename(filename);
        return readFile(f);
    }

    protected String readFile(File f) throws IOException {
        return FileUtils.readFileToString(f, Charset.defaultCharset());
    }

}
