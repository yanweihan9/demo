package com.ywh.demo;

import com.ywh.demo.config.Receiver;
import com.ywh.demo.config.Receiver2;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication(scanBasePackages = {
        "com.ywh.demo",
        "com.vanke.lib.rocketmq"
})
@MapperScan(basePackages = "com.ywh.demo.mapper")
@EnableCaching
@Slf4j
public class DemoApplication {

    public static void main(String[] args) throws Exception {

       ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
//        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
//        CountDownLatch latch = ctx.getBean(CountDownLatch.class);
//        log.info("Sending message...");
//        template.convertAndSend("chat","Hello from Redis!");
//        latch.await();
//        System.exit(0);
    }



}

