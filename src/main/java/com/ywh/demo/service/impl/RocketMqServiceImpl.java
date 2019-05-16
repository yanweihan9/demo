package com.ywh.demo.service.impl;

import com.vanke.core.util.JsonUtil;
import com.vanke.lib.rocketmq.MessageBuilder;
import com.vanke.lib.rocketmq.listener.RocketListener;
import com.vanke.lib.rocketmq.service.IRocketmqService;
import com.ywh.demo.service.RocketMqService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 颜伟晗
 * @date: 2019/5/12
 * @Description:
 */
@Service
@Slf4j
public class RocketMqServiceImpl implements RocketMqService {

    @Autowired(required = false)
    private IRocketmqService rocketmqService;
    @Override
    public Integer sendMessage(String word) {
        rocketmqService.send(MessageBuilder.topic("test-rokect-mq-wh").body(word).build());
        return 1;
    }

    @RocketListener(topic = "test-rokect-mq-wh",consumerGroup = "test-consumer-group")
    public void comsumer(String message){
        log.info("mq返回的消息:{}",message);
    }

    @RocketListener(topic = "test-rokect-mq-wh",consumerGroup = "test-consumer-group")
    public void comsumer2(String message){
        log.info("mq返回的消息2:{}",message);
    }
}
