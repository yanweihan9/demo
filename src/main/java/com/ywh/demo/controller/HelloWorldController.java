package com.ywh.demo.controller;




import com.ywh.demo.model.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 颜伟晗
 * @date: 2019/2/15
 * @Description:
 */
@RestController
public class HelloWorldController {

    @Autowired
    private ConfigBean configBean;

    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private String age;



    @GetMapping(value = "/hello")
    public String helloWorld(){
        return name+":"+age;
    }

    @GetMapping(value = "/miya")
    public String miya(){
        return configBean.getGreeting()+"->"+configBean.getName()+"->"+configBean.getUuid();
    }

}
