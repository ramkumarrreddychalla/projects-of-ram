package com.emv.tlv.service;

import java.io.InputStream;
import java.util.List;

import com.emv.tlv.Tagelement;

public interface VpaService {
	
	public List<Tagelement> sortBy(String name, String file);
	public List<Tagelement> sortBy(String name, InputStream stream);
	
}
