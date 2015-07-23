package com.emv.tlv.json.transaction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class TransactionManager {
	
	public static void main(String [] args) throws IOException{
		File directoryFile = new File("1443024002778");//new File("c:\\"+folder+"\\"+tmpFile);
    	if(!directoryFile.exists()){
    		if (directoryFile.mkdirs()) {
    			System.out.println("Directory is created!");
    			System.out.println(" path >>>> ::"+directoryFile.getPath());
    			System.out.println(" absolute path >>>> ::"+directoryFile.getAbsolutePath());
    		} else {
    			System.out.println("Failed to create directory!");
    			System.out.println(" path >>>> ::"+directoryFile.getPath());
    			System.out.println(" absolute path >>>> ::"+directoryFile.getAbsolutePath());
    		}
    	}else{
    		System.out.println(" directory exist already and the path "+directoryFile.getAbsolutePath());
    	}
    	
    	String filePath = directoryFile.getAbsolutePath()+File.separator+"123.txt";
    	System.out.println(" File Path >>>> "+filePath);
    	File file = new File(filePath);
    	OutputStream os = new FileOutputStream(file);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        bw.write(" hellllllllllllooooooo");
        bw.close();
    	
	}
	
	public static void writeToFile(Map<String, String> map){
        File tmpFile = new File("output.txt");
        OutputStream os = null;
	    // First try loading from the current directory
	    try {
	    	String folder = map.get("pan");
	    	folder = folder.replaceAll("\"", "").trim();
	    	System.out.println(" folder >>> "+folder.replaceAll("\"", "").trim());
	    	//File directoryFile = new File(folder, "output.txt");//new File("c:\\"+folder+"\\"+tmpFile);
	    	File directoryFile = new File(folder);//new File("c:\\"+folder+"\\"+tmpFile);
	    	if(!directoryFile.exists()){
	    		if (directoryFile.mkdirs()) {
	    			System.out.println("Directory is created!");
	    			System.out.println(" path >>>> ::"+directoryFile.getPath());
	    			System.out.println(" absolute path >>>> ::"+directoryFile.getAbsolutePath());
	    		} else {
	    			System.out.println("Failed to create directory!");
	    			System.out.println(" path >>>> ::"+directoryFile.getPath());
	    			System.out.println(" absolute path >>>> ::"+directoryFile.getAbsolutePath());
	    		}
	    	}else{
	    		System.out.println(" directory exist already and the path "+directoryFile.getAbsolutePath());
	    	}
	    	
	    	File file = new File(directoryFile+File.separator+UUID.randomUUID()+".txt");
	    	System.out.println(" File path >>> "+file.getAbsolutePath());
	    	os = new FileOutputStream(file);
	    	
	    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
	        for(java.util.Map.Entry<String, String> entr1 : map.entrySet()){
	        	//System.out.println(" applicationData key >>>"+entr1.getKey());
	        	//System.out.println(" applicationData value >>>"+entr1.getValue());
		    		bw.write(entr1.getKey()+":"+entr1.getValue());
		    		bw.newLine();
	         }
	        bw.close();
	      //  FileWriter writer = new FileWriter(file);
	        System.out.println(" File path >>> "+file.getAbsolutePath());  
		    }catch ( Exception e ) { 
		    	os = null; 
		    }
	  }
	
}
