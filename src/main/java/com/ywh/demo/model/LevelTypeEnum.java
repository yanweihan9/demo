package com.ywh.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author: 颜伟晗
 * @date: 2019/2/20
 * @Description:
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum LevelTypeEnum {
    LEVEL_ONE("one"),
    LEVEL_TWO("two"),
    LEVEL_THREE("three");

    private String code;

}
