package com.emv.tlv.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class GsonParser {
    public static String json = "{\"balance\": 1000.21, \"num\":100, \"is_vip\":true, \"name\":\"foo\"}";
    
    public static void main(String[] args) {
    	
    	String strLine = null;
        String strLine1 = "";
        BufferedReader reader = 
        		new BufferedReader(new InputStreamReader(
        				GsonParser.class.getClassLoader().getResourceAsStream("createcard-request.txt")));
       // String line;
        try {
    		while ((strLine = reader.readLine()) != null) {
    			System.out.println(strLine);
    			strLine1 = strLine;
    		  }
    		} catch (IOException e) {
    			e.printStackTrace();
    		} finally {
    			try {
    				if (reader != null)reader.close();
    			} catch (IOException ex) {
    				ex.printStackTrace();
    			}
    		}
    	
        Map<String, String> jsonMap = new HashMap<String, String>();
        JsonElement ele = new JsonParser().parse(strLine1);
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
    }
}