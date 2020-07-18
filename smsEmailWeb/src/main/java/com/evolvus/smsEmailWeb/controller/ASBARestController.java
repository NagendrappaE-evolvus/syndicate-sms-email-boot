/**
 * 
 */
package com.evolvus.smsEmailWeb.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.evolvus.sms.serviceImpl.SmsServiceImpl;
import com.evolvus.sms.utils.EmailSmsConstants;
import com.evolvus.smsEmailWeb.ApiService.ApiServiceInterface;
import com.evolvus.smsEmailWeb.bean.MailAndSmsApiBean;
import com.evolvus.smsEmailWeb.model.TaEmail;

/**
 * @author EVOLVUS\manishp
 *
 */
@RestController
@RequestMapping("/ASBA")
public class ASBARestController {
	private static final Logger logger = Logger.getLogger(ASBARestController.class);
	@Autowired
	private ApiServiceInterface apiServiceInterface;

	@ResponseBody
	@RequestMapping(value = "/EMAILER", method = RequestMethod.POST, consumes = "application/xml", produces = "text/html")
	public String emailRequest(@RequestBody MailAndSmsApiBean mailAndSmsApiBean) {
		logger.info("inside  controller  starts::::::");

		String ResponseString = null;

		if (EmailSmsConstants.EMAIL_ACTION.equalsIgnoreCase(mailAndSmsApiBean.getHeader().getTranscation())) {

			logger.info("Email trigger call  starts::::::"
					+ mailAndSmsApiBean.getRequestForEmail().getCreateApiRequest().getEmailId());
			TaEmail taEmail = apiServiceInterface.callEmailMethod(mailAndSmsApiBean);
			logger.info("After Email trigger call" + taEmail.getStatus());
			if ("Y".equalsIgnoreCase(String.valueOf(taEmail.getStatus()))) {
				ResponseString = "Success";
			} else {
				ResponseString = "Failure";
			}
			logger.info("Email trigger call  ends::::::" + ResponseString);
		} else if (EmailSmsConstants.SMS_ACTION.equalsIgnoreCase(mailAndSmsApiBean.getHeader().getTranscation())) {
			ResponseString = apiServiceInterface.callSmsMethod(mailAndSmsApiBean);

		}

		return ResponseString;

	}

}
