package com.robert.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.robert.spring.aop.model.Sample;

/**
 * Created by robert.
 */
@Aspect
@Component
public class SampleServiceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleServiceAspect.class);

    @Before("execution(* com.robert.spring.aop.service.SampleService.createSample (java.lang.String)) && args(sampleName)")
    public void beforeSampleCreation(String sampleName) {

        LOGGER.info("A request was issued for a sample name before: "+sampleName);
    }

    @Around("execution(* com.robert.spring.aop.service.SampleService.createSample (java.lang.String)) && args(sampleName)")
    public Object aroundSampleCreation(ProceedingJoinPoint proceedingJoinPoint,String sampleName) throws Throwable {

        LOGGER.info("A request was issued for a sample name Around: "+sampleName);

        sampleName = sampleName+"!";

        Sample sample = (Sample) proceedingJoinPoint.proceed(new Object[] {sampleName});
        sample.setName(sample.getName().toUpperCase());

        return sample;
    }

}

