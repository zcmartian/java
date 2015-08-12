package com.yunzero.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ActivemqMessageListener implements MessageListener {

	@Override
	public void onMessage(Message msg) {
		TextMessage textMsg = (TextMessage)msg;
		try {
			String message = textMsg.getText();
			System.out.println(message);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
