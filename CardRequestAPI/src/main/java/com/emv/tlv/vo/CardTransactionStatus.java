package com.emv.tlv.vo;

public class CardTransactionStatus {
	
	int cardTransactionId;
	int statusCode;
	int errorCode;
	String errorMessage;
	String status;
	
	public int getCardTransactionId() {
		return cardTransactionId;
	}
	public void setCardTransactionId(int cardTransactionId) {
		this.cardTransactionId = cardTransactionId;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
