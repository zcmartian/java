package com.dianping.marszhou;

import com.dianping.marszhou.service.InvokeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.PessimisticLockingFailureException;

/**
 * Created by marszhou on 16/3/8.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestAopSchemaAdvisors {

    ApplicationContext applicationContext = null;

    @Before
    public void setUp() {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
    }

    @Test(expected = PessimisticLockingFailureException.class)
    public void testSave() {

        InvokeService service = (InvokeService) applicationContext.getBean("invokeService");
        service.invoke();

        System.out.println();
        service.invokeException();
    }
}
