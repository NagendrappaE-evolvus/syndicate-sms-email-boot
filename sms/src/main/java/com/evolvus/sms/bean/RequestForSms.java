/**
 * 
 */
package com.evolvus.sms.bean;

import java.util.Date;

/**
 * @author EVOLVUS\nagendrappae
 *
 */
public class RequestForSms {
	
	
	private String blockedAmt;

	private String acctNum;

	private String bidNum;

	private String issueType;

	private String issueSymbol;

	private String txnTitle;

	private String mobileNum;


	private  String  appRefNum;

	private String exchangeFlag;

	private  String  localFlag;

	private  String  bankCode;

	private String templateString;
	
	private int  allottedNoOfShares;
	
	private String  allottedAmount;
	
	private int allotmentFlag;


	/**
	 * @return the allottedNoOfShares
	 */
	public int getAllottedNoOfShares() {
		return allottedNoOfShares;
	}

	/**
	 * @return the allotmentFlag
	 */
	public int getAllotmentFlag() {
		return allotmentFlag;
	}

	/**
	 * @param allotmentFlag the allotmentFlag to set
	 */
	public void setAllotmentFlag(int allotmentFlag) {
		this.allotmentFlag = allotmentFlag;
	}

	/**
	 * @param allottedNoOfShares the allottedNoOfShares to set
	 */
	public void setAllottedNoOfShares(int allottedNoOfShares) {
		this.allottedNoOfShares = allottedNoOfShares;
	}

	/**
	 * @return the allottedAmount
	 */
	public String getAllottedAmount() {
		return allottedAmount;
	}

	/**
	 * @param allottedAmount the allottedAmount to set
	 */
	public void setAllottedAmount(String allottedAmount) {
		this.allottedAmount = allottedAmount;
	}

	/**
	 * @return the blockedAmt
	 */
	public String getBlockedAmt() {
		return blockedAmt;
	}

	/**
	 * @param blockedAmt the blockedAmt to set
	 */
	public void setBlockedAmt(String blockedAmt) {
		this.blockedAmt = blockedAmt;
	}

	/**
	 * @return the acctNum
	 */
	public String getAcctNum() {
		return acctNum;
	}

	/**
	 * @param acctNum the acctNum to set
	 */
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}

	/**
	 * @return the bidNum
	 */
	public String getBidNum() {
		return bidNum;
	}

	/**
	 * @param bidNum the bidNum to set
	 */
	public void setBidNum(String bidNum) {
		this.bidNum = bidNum;
	}

	/**
	 * @return the issueType
	 */
	public String getIssueType() {
		return issueType;
	}

	/**
	 * @param issueType the issueType to set
	 */
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	/**
	 * @return the issueSymbol
	 */
	public String getIssueSymbol() {
		return issueSymbol;
	}

	/**
	 * @param issueSymbol the issueSymbol to set
	 */
	public void setIssueSymbol(String issueSymbol) {
		this.issueSymbol = issueSymbol;
	}

	/**
	 * @return the txnTitle
	 */
	public String getTxnTitle() {
		return txnTitle;
	}

	/**
	 * @param txnTitle the txnTitle to set
	 */
	public void setTxnTitle(String txnTitle) {
		this.txnTitle = txnTitle;
	}

	/**
	 * @return the mobileNum
	 */
	public String getMobileNum() {
		return mobileNum;
	}

	/**
	 * @param mobileNum the mobileNum to set
	 */
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	

	/**
	 * @return the appRefNum
	 */
	public String getAppRefNum() {
		return appRefNum;
	}

	/**
	 * @param appRefNum the appRefNum to set
	 */
	public void setAppRefNum(String appRefNum) {
		this.appRefNum = appRefNum;
	}

	/**
	 * @return the exchangeFlag
	 */
	public String getExchangeFlag() {
		return exchangeFlag;
	}

	/**
	 * @param exchangeFlag the exchangeFlag to set
	 */
	public void setExchangeFlag(String exchangeFlag) {
		this.exchangeFlag = exchangeFlag;
	}

	/**
	 * @return the localFlag
	 */
	public String getLocalFlag() {
		return localFlag;
	}

	/**
	 * @param localFlag the localFlag to set
	 */
	public void setLocalFlag(String localFlag) {
		this.localFlag = localFlag;
	}

	/**
	 * @return the bankCode
	 */
	public String getBankCode() {
		return bankCode;
	}

	/**
	 * @param bankCode the bankCode to set
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	/**
	 * @return the templateString
	 */
	public String getTemplateString() {
		return templateString;
	}

	/**
	 * @param templateString the templateString to set
	 */
	public void setTemplateString(String templateString) {
		this.templateString = templateString;
	}
	
	
	
	
	
}
