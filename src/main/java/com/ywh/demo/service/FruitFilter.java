package com.ywh.demo.service;

import com.ywh.demo.model.Fruit;

/**
 * @author: 颜伟晗
 * @date: 2019/3/2
 * @Description:
 */
@FunctionalInterface
public interface FruitFilter {
    /**
     * 传进来一个对象,可以用lambda表达式去实现这个方法
     * @param fruit
     * @return
     */
    boolean filter(Fruit fruit);

    static boolean filter(){
        return false;
    };

    boolean equals(Object o);





}
