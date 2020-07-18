/**
 * 
 */
package com.evolvus.sms.serviceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.evolvus.sms.bean.SmsBean;
import com.evolvus.sms.model.TaSms;
import com.evolvus.sms.repository.SMSCrudRepository;
import com.evolvus.sms.service.SmsService;
import com.evolvus.sms.template.AsbaTemplate;

/**
 * @author EVOLVUS\nagendrappae
 *
 */
@Service
public class SmsServiceImpl implements SmsService {
	private static final Logger logger = Logger.getLogger(SmsServiceImpl.class);

	private static final String SMS_ASBA_BIDDING_SYN = "smsAsbaBiddingTxtSYN";

	private static final String SMS_ASBA_BIDDING_MOD_SYN = "smsAsbaBiddingModTxtSYN";

	private static final String SMS_ASBA_BIDDING_CANCEL_SYN = "smsAsbaBiddingCancelTxtSYN";

	private static final String SMS_ASBA_BIDDING_REJECT_SYN = "smsEditApplicationRejectTxtSYN";

	private static final String SMS_ASBA_ALLOTMENTPOSTING_ALLOTED_SYN = "SmsTextForAllotmentSYN";

	private static final String SMS_ASBA_ALLOTMENTPOSTING_NON_ALLOTTED_SYN = "SmsTextForNon-AllotmentSYN";

	private static final String ALLOTMENT_POSTING = "ASBAPOSTING";

	@Autowired
	private AsbaTemplate asbaTemplate;

	@Autowired
	private SMSCrudRepository sMSCrudRepository;

	@Value("${syndicate_bank_code}")
	private String syndicateBankCode;

	@Value("${kvb_bank_code}")
	private String kvbBankcode;

	@Value("${sms.method}")
	private String method;

	@Value("${sms.url}")
	private String smsURL;
	@Value("${sms.userid}")
	private String userid;

	@Value("${sms.password}")
	private String password;

	@Value("${sms.msg_type}")
	private String msg_type;

	@Value("${sms.auth_scheme}")
	private String auth_scheme;

	@Value("${sms.mask}")
	private String mask;

	/***
	 * 
	 */
	public SmsBean callSMS(SmsBean smsBean) {
		logger.debug("inside  SmsServiceImpl  starts::::::");
		logger.debug("inside  SmsServiceImpl  mobile number::::::" + smsBean.getMobileNum());
		logger.debug("inside  SmsServiceImpl  exchange flag::::::" + smsBean.getExchangeFlag());
		logger.debug("inside  SmsServiceImpl  bankcode::::::" + smsBean.getBankCode());

		String templateName = null;
		try {
			if (smsBean.getBankCode().equals(syndicateBankCode)) {
				if (smsBean.getExchangeFlag() != null && smsBean.getExchangeFlag().equals("S")) {
					if (smsBean.getLocalFlag() != null && smsBean.getLocalFlag().equals("A")) {
						templateName = SMS_ASBA_BIDDING_SYN;

					} else if (smsBean.getLocalFlag() != null && smsBean.getLocalFlag().equals("M")) {
						templateName = SMS_ASBA_BIDDING_MOD_SYN;

					} else if (smsBean.getLocalFlag() != null && smsBean.getLocalFlag().equals("D")) {
						templateName = SMS_ASBA_BIDDING_CANCEL_SYN;

					}

				} else if (smsBean.getExchangeFlag() != null && smsBean.getExchangeFlag().equals("R")) {
					templateName = SMS_ASBA_BIDDING_REJECT_SYN;

				} else if (smsBean.getExchangeFlag() != null && smsBean.getExchangeFlag().equals(ALLOTMENT_POSTING)) {
					if (smsBean.getAllotmentFlag() == 1&&smsBean.getAllottedNoOfShares()>0) {
						templateName = SMS_ASBA_ALLOTMENTPOSTING_ALLOTED_SYN;
					} else {
						templateName = SMS_ASBA_ALLOTMENTPOSTING_NON_ALLOTTED_SYN;

					}
				}
			} else if (smsBean.getBankCode().equals(kvbBankcode)) {

			}

			String templateString = asbaTemplate.prepareTemplateForIsaAppTxn(smsBean, templateName);
			smsBean.setTemplateString(templateString);
			smsBean = this.sendSMS(smsBean);
			this.saveSMSDetails(smsBean);
		} catch (Exception e) {
			logger.error("inside the error:::::::" + e.getMessage());
		}
		logger.debug("inside  SmsServiceImpl  ends::::::");

		return smsBean;

	}

	/***
	 * 
	 * @param smsBean
	 * @return
	 */
	private SmsBean sendSMS(SmsBean smsBean) {
		StringBuffer buffer = null;
		logger.debug("sms  sending starts:::::::::::::::");
		try {
			Date mydate = new Date(System.currentTimeMillis());
			String data = "";
			data += "method=sendMessage";
			data += "&userid=" + userid; // your loginID
			data += "&password=" + URLEncoder.encode(password, "UTF-8"); // your
																			// password
			data += "&msg=" + URLEncoder.encode(smsBean.getTemplateString() , "UTF-8");
			data += "&send_to=" + URLEncoder.encode(smsBean.getMobileNum(), "UTF-8"); // a
																						// valid
																						// 10
																						// digit
																						// phone
																						// no.
			data += "&v=1.1";
			data += "&msg_type=" + msg_type; // Can by "FLASH" or "UNICODE_TEXT"
												// or BINARY
			data += "&auth_scheme=" + auth_scheme;
			data += "&mask=" + mask;
			URL url = new URL(smsURL + "?" + data);

			logger.debug(" inside the send SMS the sms url :::::::::::::::" + url);
			logger.debug("inside the send SMS  the  received  mobile number :::::::::::::::" + smsBean.getMobileNum());

			/**
			 * sendinfg SMS
			 */
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.connect();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			buffer = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				buffer.append(line).append("\n");
			}
			logger.debug(" inside the send SMS the Response  from SMS  :::::::::::::::" + buffer.toString());
			System.out.println(" inside the send SMS the Response  from SMS  :::::::::::::::" + buffer.toString());

			rd.close();
			conn.disconnect();
		} catch (Exception e) {
			smsBean.setSuccessFlg("FAILURE");
			logger.error("inside the sendSMS Exception ::::" + e.getMessage());
		}
		smsBean.setResponseString(buffer.toString());

		smsBean.setSuccessFlg("SUCCESS");

		return smsBean;
	}

	/***
	 * 
	 * @param smsBean
	 * @param buffer
	 */
	private void saveSMSDetails(SmsBean smsBean) {

		try {
			TaSms taSmsDtls = new TaSms();
			taSmsDtls.setPhoneNumber(smsBean.getMobileNum());
			taSmsDtls.setMessageTxt(smsBean.getTemplateString());
			taSmsDtls.setSubmittedTime(new Timestamp(System.currentTimeMillis()));
			taSmsDtls.setStatusMsg(smsBean.getResponseString());
			sMSCrudRepository.save(taSmsDtls);
		} catch (Exception e) {
			logger.error("inside  sms save   exception :::::::" + e.getMessage());
		}
	}

}
