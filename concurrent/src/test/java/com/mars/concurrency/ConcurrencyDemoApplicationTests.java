package com.mars.concurrency;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ConcurrencyDemoApplicationTests {

    private MockMvc mockMvc1;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        mockMvc1 = MockMvcBuilders.webAppContextSetup(context).build();
    }



    @Test
    public void contextLoads() {

    }

}

