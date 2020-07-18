/**
 * 
 */
package com.evolvus.sms.template;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.evolvus.sms.bean.SmsBean;

/**
 * @author EVOLVUS\nagendrappae
 *
 */
@Component
public class AsbaTemplate {

	private static final Logger logger = Logger.getLogger(AsbaTemplate.class);

	@Autowired
	private VelocityEngine velocityEngine;
	
	/***
	 * 
	 * @param smsBean
	 * @param templateName
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public  String  prepareTemplateForIsaAppTxn(SmsBean smsBean ,String templateName)
	{
		String smsAsbaBidding=null;
		String accountNumber=null;
		logger.debug("inside  AsbaTemplate starts :::::: ");
		try{
			accountNumber=	getMaskedAcctNo(smsBean.getAcctNum());
		Map<String, Object> smsMap = new HashMap<String, Object>();
		smsMap.put("appRefNum", smsBean.getAppRefNum());
		
		smsMap.put("issueSymbol",smsBean.getIssueSymbol());

		smsMap.put("blockedAmt", smsBean.getBlockedAmt());

		smsMap.put("acctNum",accountNumber);
		
		smsMap.put("issueType", smsBean.getIssueType());

		smsMap.put("allottedAmount", smsBean.getAllottedAmount());

		smsMap.put("allottedNoOfShares", smsBean.getAllottedNoOfShares());


		
		smsAsbaBidding = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateName, "UTF-8", smsMap);
		}catch(Exception e)
		{
			
		}
		logger.debug("inside  AsbaTemplate ends  :::::: ");

		return  smsAsbaBidding;
	}

	
	public  static String getMaskedAcctNo(String acctNum) {
	       
        StringBuilder acctNumWithoutStar = new StringBuilder(acctNum);
        acctNumWithoutStar.replace(4,acctNum.length()-4,"******");
        return acctNumWithoutStar.toString();
            
        }
	
}
