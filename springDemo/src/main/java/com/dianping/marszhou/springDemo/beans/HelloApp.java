package com.dianping.marszhou.springDemo.beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by marszhou on 16/2/24.
 */
public class HelloApp {
    private static ClassPathXmlApplicationContext context;

    public static void main(String[] args) throws Exception {
        context = new ClassPathXmlApplicationContext(
                "classpath:appcontext-beans.xml");
        context.start();
        GreetingService greetingService1 = (GreetingService) context
                .getBean("greetingService1");
        greetingService1.sayGreeting();
        GreetingService greetingService2 = (GreetingService) context
                .getBean("greetingService2");
        greetingService2.sayGreeting();

        Long id = (Long) context.getBean("iauthAppId");
        System.out.println(id);
    }
}
