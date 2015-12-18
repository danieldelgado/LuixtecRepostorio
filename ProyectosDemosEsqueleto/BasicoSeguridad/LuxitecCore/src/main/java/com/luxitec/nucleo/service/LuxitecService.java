package com.luxitec.nucleo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.luxitec.nucleo.msg.MessageCore;
import com.luxitec.nucleo.parse.TranslateClass;

public abstract class LuxitecService {

	@Autowired
	private TranslateClass translateClass;

	@Autowired
	private MessageCore messageCore;
	
	public TranslateClass getTranslateClass() {
		return translateClass;
	}

	public void setTranslateClass(TranslateClass translateClass) {
		this.translateClass = translateClass;
	}

	public MessageCore getMessageCore() {
		return messageCore;
	}

	public void setMessageCore(MessageCore messageCore) {
		this.messageCore = messageCore;
	}
	
}
