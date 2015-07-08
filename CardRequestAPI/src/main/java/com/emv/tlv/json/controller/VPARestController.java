package com.emv.tlv.json.controller;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	public @ResponseBody String getLiveCheck() {
		logger.info("Start getLiveCheck");
		return "live check 200::ok";
	}
	
	@RequestMapping(value = VPARestURIConstants.PARSE_JSON_TO_MAP, method = RequestMethod.POST)
	public @ResponseBody Map<String, String> parseJson(@RequestBody String strJson) {
		logger.info("Start createEmployee.");
		return GsonParser.parseJson(strJson);
	}	
	
	
}
