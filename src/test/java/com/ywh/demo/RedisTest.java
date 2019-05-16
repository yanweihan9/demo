package com.ywh.demo;

import com.ywh.demo.service.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: 颜伟晗
 * @date: 2019/3/16
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    public static Logger logger= LoggerFactory.getLogger(RedisTest.class);
    @Test
    public void contextLoads() {
    }

    @Autowired
    RedisDao redisDao;
    @Test
    public void testRedis(){
        redisDao.setKey("name","forezp");
        redisDao.setKey("age","11");
        logger.info("-----------redis测试:"+redisDao.getValue("name"));
        logger.info("-----------redis测试:"+redisDao.getValue("age"));
    }
}
