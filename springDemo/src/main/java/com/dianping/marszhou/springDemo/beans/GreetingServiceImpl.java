package com.dianping.marszhou.springDemo.beans;

/**
 * Created by marszhou on 16/2/24.
 */
public class GreetingServiceImpl implements GreetingService {
    private String greeting;

    public GreetingServiceImpl() {
    }

    public GreetingServiceImpl(String greeting) {
        this.greeting = greeting;
    }

    public void sayGreeting() {
        System.out.println(greeting);
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
