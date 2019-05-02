package com.atguigu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Car implements InitializingBean, DisposableBean, ApplicationContextAware {
    private ApplicationContext applicationContext;

    public Car() {
        System.out.println("car ...constructor...");
    }

    public void initMethod() {
        System.out.println("car ...initMethod...");
    }

    public void destroyMethod() {
        System.out.println("car ...destroyMethod...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("car ...InitializingBean.afterPropertiesSet...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("car ...DisposableBean.destroy...");
    }

    //对象创建并赋值之后调用
    @PostConstruct
    public void postConstruct(){
        System.out.println("car ...@PostConstruct...");
    }

    //容器移除对象之前
    @PreDestroy
    public void preDestroy() {
        System.out.println("car ...@PreDestroy...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("car ...setApplicationContext...");
    }
}
