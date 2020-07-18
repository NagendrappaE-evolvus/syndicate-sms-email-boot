package com.evolvus.smsEmailWeb.bean;

import javax.xml.bind.annotation.XmlRootElement;

import com.evolvus.sms.bean.RequestForSms;

@XmlRootElement(name="MailAndSmsApiBean")
public class MailAndSmsApiBean {


	
	private Header header;
	private RequestForEmail  requestForEmail;
	private ResponseForEmail  responseForEmail;
	private String responseString;
	
	private  RequestForSms requestForSms;

	/**
	 * @return the requestForSms
	 */
	public RequestForSms getRequestForSms() {
		return requestForSms;
	}
	/**
	 * @param requestForSms the requestForSms to set
	 */
	public void setRequestForSms(RequestForSms requestForSms) {
		this.requestForSms = requestForSms;
	}
	/**
	 * @return the header
	 */
	public Header getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public void setHeader(Header header) {
		this.header = header;
	}
	/**
	 * @return the requestForEmail
	 */
	public RequestForEmail getRequestForEmail() {
		return requestForEmail;
	}
	/**
	 * @param requestForEmail the requestForEmail to set
	 */
	public void setRequestForEmail(RequestForEmail requestForEmail) {
		this.requestForEmail = requestForEmail;
	}
	/**
	 * @return the responseForEmail
	 */
	public ResponseForEmail getResponseForEmail() {
		return responseForEmail;
	}
	/**
	 * @param responseForEmail the responseForEmail to set
	 */
	public void setResponseForEmail(ResponseForEmail responseForEmail) {
		this.responseForEmail = responseForEmail;
	}
	/**
	 * @return the responseString
	 */
	public String getResponseString() {
		return responseString;
	}
	/**
	 * @param responseString the responseString to set
	 */
	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}
	
	

	
}
