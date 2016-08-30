package com.robinkanters.athena.dataflow.component.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileReaderImpl implements FileReader {
    public String read(String filename) {
        try {
            return tryRead(filename);
        } catch (IOException e) {
            throw new FileReaderException(e);
        }
    }

    private String tryRead(String filename) throws IOException {
        File f = getFileForFilename(filename);
        return readFile(f);
    }

    protected File getFileForFilename(String filename) {
        return new File(filename);
    }

    protected String readFile(File f) throws IOException {
        return FileUtils.readFileToString(f, Charset.defaultCharset());
    }

    public class FileReaderException extends RuntimeException {
        public FileReaderException(Throwable cause) {
            super(cause);
        }
    }
}
