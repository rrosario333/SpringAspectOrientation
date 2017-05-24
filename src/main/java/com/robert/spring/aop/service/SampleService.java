package com.robert.spring.aop.service;

import com.robert.spring.aop.aspect.SampleServiceAspect;
import com.robert.spring.aop.model.Sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created byrobert.
 */
@Component("SampleService")
public class SampleService {
	 private static final Logger LOGGER = LoggerFactory.getLogger(SampleService.class);
    public Sample createSample(String sampleName) {

        Sample sample = new Sample();
        sample.setName(sampleName);
        LOGGER.info(" SampleService class identity"+sample.getName());

        return sample;
    }
}
