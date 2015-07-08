package com.emv.tlv.service.impl;

import java.util.Comparator;

import com.emv.tlv.Tagelement;

public class TagComparator implements Comparator<Tagelement>
{
	private final String type;

    public TagComparator(String type) {
        this.type = type;
    }
    
    public int compare(Tagelement p1, Tagelement p2)
    {
        // Assume no nulls, and simple ordinal comparisons
        // First by campus - stop if this gives a result.
    	if(type.equalsIgnoreCase("tag")){
	        int tagResult = p1.getTag().compareTo(p2.getTag());
	            return tagResult;
	    }else if(type.equalsIgnoreCase("name")){
	    	// Next by faculty
    		int tagNameResult = p1.getTagname().getCategory().compareTo(p2.getTagname().getCategory());
        	return tagNameResult;
    	}else{
	        int tagResult = p1.getTag().compareTo(p2.getTag());
            return tagResult;
    	}
        
        /*
	        if (facultyResult != 0){
	            return facultyResult;
	        }
		*/
        // Finally by building
        //return p1.getBuilding().compareTo(p2.getBuilding());
    }
}
