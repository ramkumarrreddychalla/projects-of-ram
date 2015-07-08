package com.emv.tlv.service.impl;

import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.emv.tlv.Config;
import com.emv.tlv.Tagelement;



public class JAXBClient {
	
	private static Config config;
    private static Unmarshaller unmarshaller = null;
	
	static{
		
		JAXBContext jaxbContext = null;
		try {
			jaxbContext = JAXBContext.newInstance("com.emv.tlv");
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
         
		try {
			unmarshaller = jaxbContext.createUnmarshaller();
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
	
	
	
	public static Unmarshaller getUnmarshaller() {
		return unmarshaller;
	}


	public static Config getConfig(String filePath) {
	    InputStream stream = JAXBClient.class.getResourceAsStream(filePath);
        System.out.println(stream != null);
        try {
			config  =  (Config) unmarshaller.unmarshal(stream);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return config;
	}
	
	public static Config getConfig(InputStream stream) {
	    
        try {
			config  =  (Config) unmarshaller.unmarshal(stream);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return config;
	}



	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub
		
		JAXBContext jaxbContext = JAXBContext.newInstance("com.emv.tlv");
         
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        
        InputStream stream = JAXBClient.class.getResourceAsStream("/tlv.xml");
        
        System.out.println(stream != null);

		//JAXBElement<Config> uconfigType
		  //         = (JAXBElement<Config>) unmarshaller.unmarshal(stream);
        
		Config uconfigType  =  (Config) unmarshaller.unmarshal(stream);
        
         //CourseBooking booking = bookingElement.getValue();
		
		System.out.println(uconfigType.getTagelement());

		//Config configType = uconfigType.getValue();
		List<Tagelement> tagelementTypes = uconfigType.getTagelement(); //configType.getTagelement();
		
		for(Tagelement e: tagelementTypes){
			System.out.println(" TagelementType getTag      :: "+e.getTag());
			//System.out.println(" TagelementType getTaglength:: "+e.getTaglength());
			//System.out.println(" TagelementType getTagvalue :: "+e.getTagvalue());
			System.out.println(" TagelementType getTagname  :: "+e.getTagname().getCategory());
		}
		
		System.out.println(" AFTER >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
		
		Collections.sort(tagelementTypes, new TagComparator(""));
		
		//tagelementTypes = configType.getTagelement();
		
		for(Tagelement e: tagelementTypes){
			System.out.println(" TagelementType getTag      :: "+e.getTag());
			//System.out.println(" TagelementType getTaglength:: "+e.getTaglength());
			//System.out.println(" TagelementType getTagvalue :: "+e.getTagvalue());
			System.out.println(" TagelementType getTagname  :: "+e.getTagname().getCategory());
		}
	}

}
