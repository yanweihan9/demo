package com.ywh.demo.model;

import lombok.Data;

/**
 * @author: 颜伟晗
 * @date: 2019/2/20
 * @Description:
 */
@Data
public class UserInfo {
    private long userId;
    private String userName;
    private int age;
    @LevelType(key = LevelTypeEnum.LEVEL_ONE)
    private String onelevel;
    @LevelType(key = LevelTypeEnum.LEVEL_TWO)
    private String twolevel;
}
