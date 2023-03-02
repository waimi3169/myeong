package org.example.ll;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String actionCode;
    Map<String, String> params;
    public Rq(String a) {
        String[] aBits = a.split("\\?",2);
        actionCode = aBits[0];

        params = new HashMap<>();

        if(aBits.length == 1) return;
        
        String[] paramsBits = aBits[1].split("&");

        for (String paramStr : paramsBits) {
            String[] paramStrBits = paramStr.split("=",2);
            String key = paramStrBits[0];
            String value = paramStrBits[1];

            params.put(key, value);
        }
    }

    public String getActionCode() {
        return actionCode;
    }
    public String getParam(String name) {
        return params.get(name);
    }
}
