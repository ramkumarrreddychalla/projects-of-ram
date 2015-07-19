package com.emv.tlv.json.controller;

public class VPARestURIConstants {
	public static final String LIVE_CHECK = "/rest/parse/livecheck";
	public static final String PARSE_JSON_TO_MAP = "/rest/parse/cardrequest";
	public static final String GET_CARD_STATUS = "/rest/parse/cardstatus/{cardTransactionId}";
	
	public static final String STATUS_READY = "READY";
	public static final String STATUS_PENDING = "PENDING";
	public static final String STATUS_PROGRESS = "IN PROGRESS";
	public static final String STATUS_COMPLETE = "COMPLETE";
}
