package com.ywh.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: 颜伟晗
 * @date: 2019/3/16
 * @Description:
 */
@Data
public class BaseEntity implements Serializable {
    private Integer id;
    private String remark;
    private Integer createBy;
    private Date createTime;
    private Integer updateBy;
    private Date updateTime;
    private Integer del_flg;

}
