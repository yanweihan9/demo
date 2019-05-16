package com.ywh.demo.mapper;

import com.ywh.demo.model.YinliSubjectConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: 颜伟晗
 * @date: 2019/3/16
 * @Description:
 */
@Mapper
public interface YinliSubjectConfigMapper {

    @Select("select * from yinli_subject_config")
    List<YinliSubjectConfig> findList();
}
