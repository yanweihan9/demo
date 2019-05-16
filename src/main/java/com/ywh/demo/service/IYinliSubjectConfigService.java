package com.ywh.demo.service;

import com.ywh.demo.model.YinliSubjectConfig;

import java.util.List;

/**
 * @author: 颜伟晗
 * @date: 2019/3/16
 * @Description:
 */
public interface IYinliSubjectConfigService {

    List<YinliSubjectConfig> getList(Integer id);

    Integer update(String code,Integer id);
}
