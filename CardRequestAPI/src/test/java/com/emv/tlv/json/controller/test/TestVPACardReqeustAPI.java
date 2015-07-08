package com.emv.tlv.json.controller.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.emv.tlv.json.controller.VPARestURIConstants;

public class TestVPACardReqeustAPI {

	public static final String SERVER_URI = "http://localhost:8080/CardRequestAPI";
	
	//CardRequestAPI/rest/parse/jsontomap
	
	public static void main(String args[]){
		/*
		testGetDummyEmployee();
		System.out.println("*****");
		testCreateEmployee();
		System.out.println("*****");
		testGetEmployee();
		System.out.println("*****");
		testGetAllEmployee();
		*/
		
		System.out.println("*****");
		testParseJsontoMap();
		
		
	}

	private static String readJsonfromFile(){
		String strLine = null;
        String strLine1 = "";
        BufferedReader reader = 
        		new BufferedReader(new InputStreamReader(
        				TestVPACardReqeustAPI.class.getClassLoader().getResourceAsStream("createcard-request.txt")));
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
        return strLine1;
	}
	private static void testParseJsontoMap() {
		RestTemplate restTemplate = new RestTemplate();
		String strJson = readJsonfromFile();
		Map<String, String> response = restTemplate.postForObject(SERVER_URI+VPARestURIConstants.PARSE_JSON_TO_MAP, strJson, Map.class);
		printMapData(response);
	}
	
	private static void printMapData(Map<String, String> map){
		for(String key : map.keySet()){
			System.out.println("Key ::"+key+" and Value ::"+map.get(key));
		}
		
		System.out.println(" Key = pan && value ::"+map.get("pan"));
	}
	
}
