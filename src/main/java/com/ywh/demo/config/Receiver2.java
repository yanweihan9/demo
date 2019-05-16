package com.ywh.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * @author: 颜伟晗
 * @date: 2019/3/19
 * @Description:
 */
public class Receiver2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver2.class);

    private CountDownLatch latch;

    @Autowired
    public Receiver2(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage2(String message) {
        LOGGER.info("Received2<" + message + ">");
        latch.countDown();
    }
}
