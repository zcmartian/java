package com.yunzero.activemq;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component 
public class ActivemqMessageSender implements MessageSender {

	private JmsTemplate jmsTemplate;
	
	public ActivemqMessageSender(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	@Override
	public void sendMessage(String message) {
		jmsTemplate.convertAndSend(message);
	}

}
