package com.emv.tlv.parser;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class JacksonParser {
	
	private static ObjectMapper mapper = new ObjectMapper();
	 
	  public static void main(String[] args) throws IOException
	  {
	    parseJson();
	  }
	 
	  public static void parseJson() throws IOException
	  {
		  
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
		  
	    String jsonStr = "{ \"author\": \"Steve Jin\", \"title\" : \"vSphere SDK\", \"obj\" : {\"objint\" : {}} }";
	 
	    // parsing JSON to generic object
	    Object obj = mapper.readValue(strLine1, Object.class);
	    System.out.println("obj type: " + obj.getClass().toString()); // java.util.LinkedHashMap
	    System.out.println("obj: " + obj);
	 
	    Map<String, String> m = new HashMap<String, String>();
	    // parsing JSON to Map object
	    m = (Map<String, String>)mapper.readValue(strLine1, Map.class);
	    	
	    System.out.println("map.size: " + m.size());
	    for(Object key: m.keySet())
	    {
	      System.out.println("key:" + key);
	      System.out.println("value :" + m.get(key));
	    }
	    // parsing JSON to concrete Object
	  }
}
	
	

