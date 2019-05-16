package com.ywh.demo.config;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @author: 颜伟晗
 * @date: 2019/4/4
 * @Description:
 */
@Component
public class AQReceiver {
    private CountDownLatch latch = new CountDownLatch(2);
    public void receiveMessage1(String message){
        System.out.println("Received<" + message +">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
