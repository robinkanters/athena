package com.robinkanters.athena.dataflow;

public class Flow {
    private String payload;

    public void setPayload(String payload) {
        if(payload == null)
            payload = "";
        this.payload = payload;
    }

    public void run() {

    }

    public String getPayload() {
        return payload;
    }
}
