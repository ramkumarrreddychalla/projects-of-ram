package com.emv.tlv.json.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class GsonParser {
    public static String json = "{\"balance\": 1000.21, \"num\":100, \"is_vip\":true, \"name\":\"foo\"}";
    
    public static void writeToFile(Map<String, String> map){
    	
    }
    public static Map<String, String> parseJson(String strJson) {
    	Map<String, String> jsonMap = new HashMap<String, String>();
        JsonElement ele = new JsonParser().parse(strJson);
        for(java.util.Map.Entry<String, JsonElement> entr : ele.getAsJsonObject().entrySet()){
            System.out.println(entr.getKey());
            System.out.println(entr.getValue());
            
            
            if("applicationData".equals(entr.getKey())){
            	JsonElement ele1 = entr.getValue();
            	for(java.util.Map.Entry<String, JsonElement> entr1 : ele1.getAsJsonObject().entrySet()){
                    System.out.println(" applicationData key >>>"+entr1.getKey());
                    System.out.println(" applicationData value >>>"+entr1.getValue());
                    jsonMap.put(entr1.getKey(), entr1.getValue().toString());
            	}
            }

            jsonMap.put(entr.getKey(), entr.getValue().toString());
            
            System.out.println(" SIZE >>> "+jsonMap.size());
        }
        return jsonMap;
    }
}