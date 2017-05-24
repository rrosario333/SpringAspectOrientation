package com.robert.spring.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.robert.spring.aop.service.SampleService;

/**
 * Created by robert.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication();
        ApplicationContext applicationContext = springApplication.run(Application.class,args);
        SampleService s=(SampleService) applicationContext.getBean("SampleService");
        s.createSample("Robert Rosario");
    }
}
