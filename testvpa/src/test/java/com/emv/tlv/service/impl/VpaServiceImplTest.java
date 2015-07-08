package com.emv.tlv.service.impl;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import com.emv.tlv.Tagelement;
import com.emv.tlv.service.VpaService;

public class VpaServiceImplTest {

	@Test
	public void testSortByTag() {
		VpaService service = new VpaServiceImpl();
		List<Tagelement> elements = service.sortBy("tag", "/tlv.xml");
		
		System.out.println(" elements size >>> "+elements.size());
		
		for(Tagelement element : elements){
			System.out.println(" elements getValue >>> "+element.getTag());
			//System.out.println(" elements getCategory >>> "+element.getTagname().getCategory());
		}
		
		assertNotNull(elements);
	}
	
	
	//@Test
	public void testSortStreamByTag() {
		VpaService service = new VpaServiceImpl();
		  InputStream stream = JAXBClient.class.getResourceAsStream("/tlv.xml");
		List<Tagelement> elements = service.sortBy("tag", stream);
		System.out.println(" elements size >>> "+elements.size());
		
		for(Tagelement element : elements){
			System.out.println(" elements getValue >>> "+element.getTagname().getValue());
			//System.out.println(" elements getCategory >>> "+element.getTagname().getCategory());
		}
		
		int size = elements.size();
		assertNotNull(elements);
	}
	
	
	//@Test
	public void testSortByTagName() {
		VpaService service = new VpaServiceImpl();
		List<Tagelement> elements = service.sortBy("name", "/tlv.xml");
		
		System.out.println(" elements size >>> "+elements.size());
		
		for(Tagelement element : elements){
			//System.out.println(" elements getValue >>> "+element.getTagname().getValue());
			System.out.println(" elements getCategory >>> "+element.getTagname().getCategory());
		}
		
		assertNotNull(elements);
	}
	
	
	//@Test
	public void testSortStreamByTagName() {
		VpaService service = new VpaServiceImpl();
		  InputStream stream = JAXBClient.class.getResourceAsStream("/tlv.xml");
		List<Tagelement> elements = service.sortBy("name", stream);
		System.out.println(" elements size >>> "+elements.size());
		
		for(Tagelement element : elements){
			//System.out.println(" elements getValue >>> "+element.getTagname().getValue());
			System.out.println(" elements getCategory >>> "+element.getTagname().getCategory());
		}
		
		int size = elements.size();
		assertNotNull(elements);
	}


	

}
