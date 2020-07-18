package com.evolvus.smsEmailWeb.bean;



public class Header {

	


	private Long channelId;
	
	private String transcation;
	
	

	/**
	 * @return the txnFlg
	 */


	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	/**
	 * @return the transcation
	 */
	public String getTranscation() {
		return transcation;
	}

	/**
	 * @param transcation the transcation to set
	 */
	
	public void setTranscation(String transcation) {
		this.transcation = transcation;
	}

}
