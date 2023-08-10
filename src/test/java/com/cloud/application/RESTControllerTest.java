package com.cloud.application;

import com.cloud.application.controller.RESTController;
import com.cloud.application.entity.ResponseEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@RunWith(org.springframework.test.context.junit4.SpringRunner.class)
@WebAppConfiguration
public class RESTControllerTest {

    @Autowired
    private RESTController controller;

    @Test
    public void testGet() {
        ResponseEntity response = controller.index();
        Assert.assertEquals("Hello", response.getMessage());
    }
}
