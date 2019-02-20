package com.ywh.demo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: 颜伟晗
 * @date: 2019/2/15
 * @Description:
 */
@Data
@Component
@ConfigurationProperties(prefix = "my")
public class ConfigBean {
    private String name;
    private int age;
    private int number;
    private String uuid;
    private int max;
    private String value;
    private String greeting;
}
