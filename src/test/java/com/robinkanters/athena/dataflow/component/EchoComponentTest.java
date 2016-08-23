package com.robinkanters.athena.dataflow.component;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class EchoComponentTest {
    private EchoComponent echoComponent;
    private OutputSpy spy;

    @Before
    public void setUp() throws Exception {
        spy = new OutputSpy();
        echoComponent = new EchoComponent(spy);
    }

    @Test
    public void runReturnsInputAsOutput() throws Exception {
        assertEquals("Foo", echoComponent.run("Foo"));
    }
    
    @Test
    public void runPrintsPayloadToOutput() throws Exception {
        echoComponent.run("Foo");

        assertEquals("Foo\n", spy.getPrint());
    }

    private class OutputSpy extends PrintStream {
        private String print = "";

        OutputSpy() {
            super(new DummyOutputStream());
        }

        public void println(String x) {
            print += x;
            print += "\n";
        }

        public String getPrint() {
            return print;
        }
    }

    private class DummyOutputStream extends OutputStream{
        public void write(int b) throws IOException {}
    }
}
