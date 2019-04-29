package com.atguigu.test;

import com.atguigu.tx.TxConfig;
import com.atguigu.tx.UserServiceTx;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTestTx {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(TxConfig.class);

        UserServiceTx userService = applicationContext.getBean(UserServiceTx.class);

        userService.insertUser();
        applicationContext.close();
    }

}
