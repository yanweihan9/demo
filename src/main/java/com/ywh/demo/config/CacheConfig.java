package com.ywh.demo.config;

import com.vanke.core.cache.template.CacheTemplate;
import com.vanke.core.json.JsonConverter;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author 陈景阳
 * @since 2018/1/17
 */
@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {

    @Bean
    public CacheTemplate getCacheTemplate(StringRedisTemplate stringRedisTemplate) {
        CacheTemplate template = new CacheTemplate();
        template.setJsonConverter(new JsonConverter());
        template.setStringRedisTemplate(stringRedisTemplate);
        return template;
    }

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }


}
