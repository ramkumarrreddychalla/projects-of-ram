package com.emv.tlv.json.controller;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.emv.tlv.json.parser.GsonParser;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class VPARestController {
	
	private static final Logger logger = LoggerFactory.getLogger(VPARestController.class);
	
	
	@RequestMapping(value = VPARestURIConstants.LIVE_CHECK, method = RequestMethod.GET)
	public ResponseEntity<String> getLiveCheck() {
		logger.info("Start getLiveCheck");
		return new ResponseEntity<String>("Health Check complete::"+HttpStatus.OK, HttpStatus.OK);
	}
	
	@RequestMapping(value = VPARestURIConstants.PARSE_JSON_TO_MAP, method = RequestMethod.POST)
	public ResponseEntity<String> parseJson(@RequestBody String strJson) {
		logger.info("Start parsing JSON to MAP.");
		//return GsonParser.parseJson(strJson);
		try{
			Map<String, String> map = GsonParser.parseJson(strJson);
		}catch(Exception exp){
			return new ResponseEntity<String>("Chip encode Failed::"+HttpStatus.BAD_REQUEST+" Exception::"+ exp.toString(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Chip Encode Request complete::"+HttpStatus.OK, HttpStatus.OK);
	}	
	
	
}
