package com.ywh.demo;


import com.ywh.demo.model.Fruit;
import com.ywh.demo.service.FruitFilter;
import org.assertj.core.util.Lists;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

/**
 * @author: 颜伟晗
 * @date: 2019/3/2
 * @Description:
 */
public class Java8Test1 {

    /**
     * 把水果集合以某种自定义的方式进行过滤
     *
     * @param fruits      水果集合
     * @param filterFruit 过滤的接口
     * @return 水果集合
     */
    public static List<Fruit> findFruit(List<Fruit> fruits, FruitFilter filterFruit) {
        List<Fruit> list = Lists.newArrayList();
        for (Fruit fruit : fruits) {
            if (filterFruit.filter(fruit)) {
                list.add(fruit);
            }
        }
        return list;

    }


    public static void main(String[] args) {

        List<Fruit> fruits = Fruit.getList();
        fruits.forEach(fruit -> System.out.println(fruit));
        List<Fruit> fruitList1 = findFruit(fruits, fruit -> "apple".equals(fruit.getName()));
        System.out.println(fruitList1);
        System.out.println("---------------------");
        List<Fruit> fruitList = fruits.stream().filter(fruit -> "apple".equals(fruit.getName())).collect(toList());
        System.out.println(fruitList);

    }
}
