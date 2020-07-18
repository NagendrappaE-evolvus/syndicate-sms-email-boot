package com.evolvus.smsEmailWeb.ApiService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evolvus.sms.bean.SmsBean;
import com.evolvus.sms.service.SmsService;
import com.evolvus.sms.serviceImpl.SmsServiceImpl;
import com.evolvus.smsEmailWeb.ApiService.ApiServiceInterface;
import com.evolvus.smsEmailWeb.Emailer.SendAttachment;
import com.evolvus.smsEmailWeb.bean.MailAndSmsApiBean;
import com.evolvus.smsEmailWeb.model.TaEmail;
import com.evolvus.smsEmailWeb.repository.EmailCrudRepository;

@Component
public class ApiServiceImpl implements ApiServiceInterface {
	private static final Logger logger = Logger.getLogger(ApiServiceImpl.class);

	@Autowired
	private EmailCrudRepository emailRepositoy;

	@Autowired
	private SmsService smsService;

	@Override
	/***
	 * 
	 */
	public TaEmail callEmailMethod(MailAndSmsApiBean mailAndSmsApiBean) {
		logger.info("inside callEmailMethod:::::::"
				+ mailAndSmsApiBean.getRequestForEmail().getCreateApiRequest().getEmailId());
		List<TaEmail> lisOfTaEmail = emailRepositoy.findByEmailId(
				Integer.valueOf(mailAndSmsApiBean.getRequestForEmail().getCreateApiRequest().getEmailId()));
		logger.info("callEmailMethod:::::::" + lisOfTaEmail.get(0).getFromAddr());
		logger.info("sendConformationEmail starts:::::::" + lisOfTaEmail.get(0).getEmailId());
		TaEmail taEmail = this.sendConformationEmail(lisOfTaEmail.get(0), mailAndSmsApiBean);
		logger.info("sendConformationEmail ends:::::::" + taEmail.getStatus());
		logger.info("save method starts:::::::" + taEmail.getStatus());
		emailRepositoy.save(taEmail);
		logger.info("save method ends:::::::" + taEmail.getStatus());
		logger.info("callEmailMethod ends:::::::" + taEmail.getStatus());
		return taEmail;
	}

	/***
	 * 
	 * @param taEmail
	 * @param mailAndSmsApiBean
	 * @return
	 */
	TaEmail sendConformationEmail(TaEmail taEmail, MailAndSmsApiBean mailAndSmsApiBean) {
		/*
		 * if (log.isDebugEnabled())
		 * log.debug("EmailServiceImpl:sendConformationEmail:start");
		 */

		logger.info("sendConformationEmail starts:::::::" + taEmail.getEmailId());
		String mailId;
		boolean emailStatus = false;
		String emailSubjectTxt = taEmail.getSubject();
		SendAttachment smtpMailSender = new SendAttachment();

		String emailFromAddress = mailAndSmsApiBean.getRequestForEmail().getCreateApiRequest().getEmailFrom();
		smtpMailSender.SMTP_HOST = mailAndSmsApiBean.getRequestForEmail().getCreateApiRequest().getEmailHost();
		smtpMailSender.SMTP_PWD = mailAndSmsApiBean.getRequestForEmail().getCreateApiRequest().getPassWord();
		smtpMailSender.SMTP_USER = mailAndSmsApiBean.getRequestForEmail().getCreateApiRequest().getEmailFrom();
		String[] toAddress = { taEmail.getToAddr() };
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		String modifiedDate = formatter.format(currentDate.getTime());

		byte[] getReportBodyContentAsBytes = null;
		byte[] getReportContentAsBytes = null;

		getReportBodyContentAsBytes = taEmail.getReportBodyContentBlob();
		getReportContentAsBytes = taEmail.getReportContentBlob();

		Object[] object = null;
		logger.info("sendEmail starts:::::::" + toAddress);
		logger.info("sendEmail starts:::::::" + emailSubjectTxt);
		logger.info("sendEmail starts:::::::" + emailFromAddress);
		try {
			object = smtpMailSender.sendEmail(toAddress, emailSubjectTxt, getReportContentAsBytes, emailFromAddress,
					getReportBodyContentAsBytes, mailAndSmsApiBean);

			logger.info("sendEmail ends with success:::::::");
		} catch (MessagingException e) {
			logger.error("sendEmail ends with error:::::::");
			e.printStackTrace();
		}
		if (object[1] != null) {

			mailId = (String) object[1];
			emailStatus = (Boolean) object[0];
		}
		if (emailStatus) {
			taEmail.setStatus('Y');
			taEmail.setModifiedDate(modifiedDate);

		} else {
			taEmail.setStatus('B');
			taEmail.setModifiedDate(modifiedDate);
		}
		logger.info("sendConformationEmail ends:::::::" + taEmail.getStatus());
		return taEmail;
	}

	@Override
	/***
	 * 
	 */
	public String callSmsMethod(MailAndSmsApiBean mailAndSmsApiBean) {

		SmsBean smsBean = new SmsBean();

		smsBean.setAcctNum(mailAndSmsApiBean.getRequestForSms().getAcctNum());
		smsBean.setBlockedAmt(mailAndSmsApiBean.getRequestForSms().getBlockedAmt());
		smsBean.setIssueSymbol(mailAndSmsApiBean.getRequestForSms().getIssueSymbol());
		smsBean.setIssueType(mailAndSmsApiBean.getRequestForSms().getIssueType());
		smsBean.setMobileNum(mailAndSmsApiBean.getRequestForSms().getMobileNum());
		smsBean.setExchangeFlag(mailAndSmsApiBean.getRequestForSms().getExchangeFlag());
		smsBean.setLocalFlag(mailAndSmsApiBean.getRequestForSms().getLocalFlag());
		smsBean.setBankCode(mailAndSmsApiBean.getRequestForSms().getBankCode());
		smsBean.setAppRefNum(mailAndSmsApiBean.getRequestForSms().getAppRefNum());
		smsBean.setAllottedAmount(mailAndSmsApiBean.getRequestForSms().getAllottedAmount());
		smsBean.setAllottedNoOfShares(mailAndSmsApiBean.getRequestForSms().getAllottedNoOfShares());
		smsBean.setAllotmentFlag(mailAndSmsApiBean.getRequestForSms().getAllotmentFlag());
		smsBean = smsService.callSMS(smsBean);
		return smsBean.getSuccessFlg();
	}

}
