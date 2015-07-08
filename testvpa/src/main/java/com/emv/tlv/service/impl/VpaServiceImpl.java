package com.emv.tlv.service.impl;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.Unmarshaller;

import com.emv.tlv.Config;
import com.emv.tlv.Tagelement;
import com.emv.tlv.service.VpaService;

public class VpaServiceImpl implements VpaService{
	
	public List<Tagelement> sortBy(String name, String file) {
		Config config = JAXBClient.getConfig(file);
		List<Tagelement> tagElements = config.getTagelement();
		if(tagElements != null){
			Collections.sort(tagElements, new TagComparator(name));
		}
		return tagElements;
	}
	
	public List<Tagelement> sortBy(String name, InputStream stream){
		Config config = JAXBClient.getConfig(stream);
		List<Tagelement> tagElements = config.getTagelement();
		if(tagElements != null){
			Collections.sort(tagElements, new TagComparator(name));
		}
		return tagElements;
	}
	 
}
