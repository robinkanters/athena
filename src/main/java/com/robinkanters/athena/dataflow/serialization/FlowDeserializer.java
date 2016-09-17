package com.robinkanters.athena.dataflow.serialization;

import com.robinkanters.athena.dataflow.Flow;
import org.json.JSONObject;

public class FlowDeserializer {
    public static final String DISPLAYNAME_FIELD = "name";

    public Flow deserialize(String serialized) {
        if(serialized == null || serialized.isEmpty())
            serialized = "{}";

        return deserialize(new JSONObject(serialized));
    }

    public Flow deserialize(JSONObject serialized) {
        final Flow flow = new Flow();

        if(serialized.has(DISPLAYNAME_FIELD))
            flow.setDisplayName(serialized.getString(DISPLAYNAME_FIELD));

        return flow;
    }

}
