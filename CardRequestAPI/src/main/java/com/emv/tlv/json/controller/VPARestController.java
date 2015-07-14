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
import org.springframework.web.bind.annotation.RestController;

import com.emv.tlv.json.parser.GsonParser;
import com.emv.tlv.vo.CardTransactionStatus;

/**
 * Handles requests for the Employee service.
 */
@RestController
public class VPARestController {
	
	private static final Logger logger = LoggerFactory.getLogger(VPARestController.class);
	
	
	@RequestMapping(value = VPARestURIConstants.LIVE_CHECK, method = RequestMethod.GET)
	public ResponseEntity<String> getLiveCheck() {
		logger.info("Start getLiveCheck");
		return new ResponseEntity<String>("Health Check complete::"+HttpStatus.OK, HttpStatus.OK);
	}
	
	@RequestMapping(value = VPARestURIConstants.PARSE_JSON_TO_MAP, method = RequestMethod.POST)
	public ResponseEntity<CardTransactionStatus> parseJson(@RequestBody String strJson) {
		logger.info("Start parsing JSON to MAP.");
		//return GsonParser.parseJson(strJson);
		
		Map<String, String> map;
		CardTransactionStatus status = new CardTransactionStatus();
		try{
			 map = GsonParser.parseJson(strJson);
		}catch(Exception exp){
			status.setCardTransactionId(0);
			status.setStatusCode(""+HttpStatus.BAD_REQUEST);
			status.setErrorCode(""+HttpStatus.BAD_REQUEST);
			status.setErrorMessage("Chip encode Failed");
			return new ResponseEntity<CardTransactionStatus>(status, HttpStatus.BAD_REQUEST);
		}
		
		status.setCardTransactionId(Integer.parseInt(map.get("cardTransactionId")));
		status.setStatusCode(""+HttpStatus.OK);
		status.setErrorCode("");
		status.setErrorMessage("");
		
		//{"cardTransactionId":54321,"statusCode":0,"errorCode":0,"errorMessage":null}
		//return new ResponseEntity<String>("Chip Encode Request complete::"+HttpStatus.OK, HttpStatus.OK);
		
		return new ResponseEntity<CardTransactionStatus>(status, HttpStatus.OK);
		
	}	
	
	
}
