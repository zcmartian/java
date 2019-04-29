package com.atguigu;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext applicationContext = null;
        Person bean = null;
        applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        bean = (Person) applicationContext.getBean("person");
        System.out.println(bean);

        applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        bean = applicationContext.getBean(Person.class);
        System.out.println(bean);

        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : namesForType) {
            System.out.println(name);
        }

        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }
}
