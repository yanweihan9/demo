package com.ywh.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

/**
 * @author: 颜伟晗
 * @date: 2019/3/2
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fruit {
    /**
     * 名称
     */
    String name;
    /**
     * 重量
     */
    Integer weight;

    /**
     * 获取水果的集合
     *
     * @return
     */
    public static List<Fruit> getList() {

        List<Fruit> list = Arrays.asList(new Fruit("apple", 1),
                new Fruit("apple", 2),
                new Fruit("banana", 10),
                new Fruit("banana", 20));
        return list;
    }

}
