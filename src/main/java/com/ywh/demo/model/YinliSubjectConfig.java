package com.ywh.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: 颜伟晗
 * @date: 2019/3/16
 * @Description:
 */
@Data
public class YinliSubjectConfig extends BaseEntity implements Serializable {
    private String code;
    private Integer incomeTypeId;
    private Integer incomeTypeLevel;
    private Integer financialSubjectId;
}
