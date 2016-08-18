package com.robinkanters.athena;

import com.robinkanters.athena.format.DecimalFormatter;

import java.util.HashMap;

public class Variables extends HashMap<String, String> implements KeyValueStore {
    private DecimalFormatter formatter = new DecimalFormatter();

    public void put(String key, int value) {
        put(key, value+"");
    }

    public void put(String key, double value) {
        put(key, formatter.format(value));
    }

    public void put(String key, long value) {
        put(key, formatter.format(value));
    }
}
