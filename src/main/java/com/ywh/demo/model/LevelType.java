package com.ywh.demo.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: 颜伟晗
 * @date: 2019/2/20
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface LevelType {

    LevelTypeEnum key();
}
