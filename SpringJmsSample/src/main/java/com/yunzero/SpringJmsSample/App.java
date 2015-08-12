package com.yunzero.SpringJmsSample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yunzero.activemq.MessageReceiver;
import com.yunzero.activemq.MessageSender;


public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext ctx = 
    			new ClassPathXmlApplicationContext("sample1.xml");
    	/*MessageSender sender = ctx.getBean(MessageSender.class);
    	sender.sendMessage("Hello");
    	
    	MessageReceiver receiver = ctx.getBean(MessageReceiver.class);
    	String msg = receiver.receiveMessage();
    	System.out.println(msg);
    	ctx.close();
    	*/
    }
}
