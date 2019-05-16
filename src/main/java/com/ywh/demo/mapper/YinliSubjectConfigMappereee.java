package com.ywh.demo.mapper;

import com.ywh.demo.model.YinliSubjectConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: 颜伟晗
 * @date: 2019/3/16
 * @Description:
 */
public interface YinliSubjectConfigMappereee {

    void update(@Param("code") String code, @Param("id") Integer id);

    List<YinliSubjectConfig> getlist(@Param("id") Integer id);
}
