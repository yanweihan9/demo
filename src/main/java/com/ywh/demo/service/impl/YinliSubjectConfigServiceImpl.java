package com.ywh.demo.service.impl;

import com.ywh.demo.mapper.YinliSubjectConfigMapper;
import com.ywh.demo.mapper.YinliSubjectConfigMappereee;
import com.ywh.demo.model.YinliSubjectConfig;
import com.ywh.demo.service.IYinliSubjectConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 颜伟晗
 * @date: 2019/3/16
 * @Description:
 */
@Service
@Slf4j
public class YinliSubjectConfigServiceImpl implements IYinliSubjectConfigService {

    @Autowired
    private YinliSubjectConfigMapper yinliSubjectConfigMapper;
    @Autowired
    private YinliSubjectConfigMappereee yinliSubjectConfigMappereee;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    //@Cacheable(cacheNames="ywh",key = "''+#id")
    public List<YinliSubjectConfig> getList(Integer id) {
        //log.info("Sending message...");
        //stringRedisTemplate.convertAndSend("chat","Hello from Redis!--");
        List<YinliSubjectConfig> list = yinliSubjectConfigMappereee.getlist(id);
        return list;
    }

    @Override
    public Integer update(String code, Integer id) {
        yinliSubjectConfigMappereee.update(code,id);
        return 1;
    }


}
