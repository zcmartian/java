package com.yunzero.activemq;

import org.springframework.jms.core.JmsTemplate;

public class ActivemqMessageReceiver implements MessageReceiver {

    private JmsTemplate jmsTemplate;

    public ActivemqMessageReceiver(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public String receiveMessage() {
        String result = (String) jmsTemplate.receiveAndConvert();
        return result;
    }

}
