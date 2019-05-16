package com.ywh.demo.controller;

import com.ywh.demo.model.YinliSubjectConfig;
import com.ywh.demo.service.IYinliSubjectConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: 颜伟晗
 * @date: 2019/3/16
 * @Description:
 */
@Api("印力配置表")
@RestController
@RequestMapping("/yinli")
public class YinliSubjectConfigController {

    @Autowired
    @Qualifier(value = "yinliSubjectConfigServiceImpl")
    private IYinliSubjectConfigService yinliSubjectConfigServiceImpl;

    @ApiOperation(value = "查询",notes = "查询配置列表")
    @GetMapping("/config/{id}")
    public List<YinliSubjectConfig> list(@PathVariable("id") Integer id) {
        return yinliSubjectConfigServiceImpl.getList(id);
    }

    @PutMapping(value = "/update")
    public Integer update(@RequestParam("code") String code,
                          @RequestParam("id") Integer id) {
        return yinliSubjectConfigServiceImpl.update(code, id);
    }

}
