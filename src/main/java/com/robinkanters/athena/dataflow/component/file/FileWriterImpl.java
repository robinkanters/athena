package com.robinkanters.athena.dataflow.component.file;

import com.robinkanters.athena.dataflow.component.file.exception.FileWriterException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.apache.commons.io.FileUtils.writeStringToFile;

public class FileWriterImpl extends FileInteractor implements FileWriter {
    public void write(String filename, String contents) {
        try {
            tryWrite(filename, contents);
        } catch (IOException e) {
            throw new FileWriterException(e);
        }
    }

    protected void tryWrite(String filename, String contents) throws IOException {
        File f = getFileForFilename(filename);
        writeFile(f, contents);
    }

    protected void writeFile(File f, String contents) throws IOException {
        writeStringToFile(f, contents, Charset.defaultCharset());
    }

}
