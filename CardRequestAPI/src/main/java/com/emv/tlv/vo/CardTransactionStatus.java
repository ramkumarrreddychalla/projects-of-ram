package com.emv.tlv.vo;

public class CardTransactionStatus {
	
	int cardTransactionId;
	String statusCode;
	String errorCode;
	String errorMessage;
	public int getCardTransactionId() {
		return cardTransactionId;
	}
	public void setCardTransactionId(int cardTransactionId) {
		this.cardTransactionId = cardTransactionId;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
