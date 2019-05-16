package com.ywh.demo.service.impl;

import com.ywh.demo.config.AQReceiver;
import com.ywh.demo.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author: 颜伟晗
 * @date: 2019/4/4
 * @Description:
 */
@Component
public class Runner implements CommandLineRunner{

    private final RabbitTemplate rabbitTemplate;
    private final AQReceiver receiver;
    private final ConfigurableApplicationContext context;

    public Runner(AQReceiver receiver, RabbitTemplate rabbitTemplate,
                  ConfigurableApplicationContext context) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
        this.context = context;
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(RabbitmqConfig.queueName, "Hello from RabbitMQ3");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        context.close();
    }
}
