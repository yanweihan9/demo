package com.ywh.demo.controller;

import com.ywh.demo.service.RocketMqService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 颜伟晗
 * @date: 2019/5/12
 * @Description:
 */
@Api("测试rocketMq")
@RestController
@RequestMapping("/rocketMq")
public class RocektMqProducerController {

    @Autowired
    private RocketMqService rocketMqService;


    @PostMapping("/send")
    public Integer update(@RequestParam("word") String word) {
        return rocketMqService.sendMessage(word);
    }

}
