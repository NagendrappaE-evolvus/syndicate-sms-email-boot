package com.evolvus.smsEmailWeb.ApiService;

import org.springframework.stereotype.Component;

import com.evolvus.smsEmailWeb.bean.MailAndSmsApiBean;
import com.evolvus.smsEmailWeb.model.TaEmail;


public interface ApiServiceInterface {

	
	public TaEmail  callEmailMethod(MailAndSmsApiBean mailAndSmsApiBean);
	public  String callSmsMethod(MailAndSmsApiBean mailAndSmsApiBean);

}
