/**
 * 
 */
package com.evolvus.sms.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author EVOLVUS\nagendrappae
 *
 */
@Entity
@Table(name = "MIDE_PUSH_MESSAGE_LOG")
public class TaSms implements Serializable{
	private static final long serialVersionUID = -1340978779095092824L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SWS_MESSAGEID_NAME")
	@SequenceGenerator(name = "SWS_MESSAGEID_NAME", sequenceName = "SWS_MESSAGEID")
	@Column(name = "MESSAGEID")
	private Integer messageId;

	@Column(name = "MESSAGETEXT")
	private String messageTxt;

	@Column(name = "SUBMITTEDTIME")
	private Timestamp submittedTime;

	@Column(name = "PHONENUMBER")
	private String phoneNumber;

	@Column(name = "STATUSMSG")
	private String statusMsg;

	/**
	 * @return the messageId
	 */
	public Integer getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	/**
	 * @return the messageTxt
	 */
	public String getMessageTxt() {
		return messageTxt;
	}

	/**
	 * @param messageTxt the messageTxt to set
	 */
	public void setMessageTxt(String messageTxt) {
		this.messageTxt = messageTxt;
	}

	/**
	 * @return the submittedTime
	 */
	public Timestamp getSubmittedTime() {
		return submittedTime;
	}

	/**
	 * @param submittedTime the submittedTime to set
	 */
	public void setSubmittedTime(Timestamp submittedTime) {
		this.submittedTime = submittedTime;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the statusMsg
	 */
	public String getStatusMsg() {
		return statusMsg;
	}

	/**
	 * @param statusMsg the statusMsg to set
	 */
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

}
