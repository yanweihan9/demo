package com.ywh.demo;

import com.ywh.demo.model.Fruit;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: 颜伟晗
 * @date: 2019/3/2
 * @Description:
 */
public class Java8Test2 {

    /**
     * 方法推导
     */
    @Test
    public void test1() {
        Function<Fruit, Integer> getWeight = Fruit::getWeight;
        Integer weight = getWeight.apply(new Fruit("apple", 66));
        System.out.println(weight);
        Collections.sort(Fruit.getList(), (o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));
        Collections.sort(Fruit.getList(), Comparator.comparing(Fruit::getWeight));
    }

    /**
     * 得到用水果名做key的map集合(groupinBy)
     */
    @Test
    public void test2() {
        List<Fruit> list = Fruit.getList();
        Map<String, List<Fruit>> map = new HashMap<>();
        list.stream().forEach(fruit -> {
            List<Fruit> fruits = map.get(fruit.getName());
            if (fruits == null) {
                fruits = Lists.newArrayList();
                map.put(fruit.getName(), fruits);
            }
            fruits.add(fruit);
        });
        System.out.println(map);

        //stream
        Map<String, List<Fruit>> map1 = list.stream().collect(Collectors.groupingBy(Fruit::getName));
        System.out.println(map1);
    }

    /**
     * 对上面的得到的结果再进行操作(Collectors.groupinBy   Collectors.averagingInt
     */
    @Test
    public void test3() {
        List<Fruit> list = Fruit.getList();
        Map<String, Double> map = list.stream().collect(Collectors.groupingBy(Fruit::getName, Collectors.averagingInt(Fruit::getWeight)));
        System.out.println(map);
        System.out.println(map.getClass());

        Map<String, Double> map1 = list.stream().collect(Collectors.groupingBy(Fruit::getName, ConcurrentSkipListMap::new, Collectors.averagingInt(Fruit::getWeight)));
        System.out.println(map1);
        System.out.println(map1.getClass());
        //上述的groupingBy()  都可以换成  groupingByConcurrent(),这个为并行的操作
    }

    /**
     * Collectors.collectingAndThen  Collectors.toList(),Collectors.toSet(),stream().distinct()
     */
    @Test
    public void test4() {
        List<Fruit> list = Fruit.getList();
        List<String> names = list.stream().map(Fruit::getName).collect(Collectors.toList());
        System.out.println(names);
        List<String> newNames = list.stream().map(Fruit::getName).collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        System.out.println(newNames);
        newNames.add("xxx");
    }

    /**
     * toMap,summarizingInt,reducing
     */
    @Test
    public void test5() {
        List<Fruit> list = Fruit.getList();
        //解决map key不可以重复问题
        Map<String, Integer> collect = list.stream().collect(Collectors.toMap(Fruit::getName, Fruit::getWeight, (a, b) -> a));
        System.out.println(collect);

        IntSummaryStatistics statistics = list.stream().collect(Collectors.summarizingInt(Fruit::getWeight));
        System.out.println(statistics);
        System.out.println(statistics.getMax() + ":" + statistics.getSum());

        Integer sum1 = list.stream().collect(Collectors.reducing(0, Fruit::getWeight, Integer::sum));
        Optional<Integer> collect1 = list.stream().map(Fruit::getWeight).collect(Collectors.reducing(Integer::sum));
        Integer sum2 = collect1.get();
        Integer sum3 = list.stream().collect(Collectors.summingInt(Fruit::getWeight));
        System.out.println(sum1 + ":" + sum2 + ":" + sum3);
    }

    /**
     * joining
     */
    @Test
    public void test6() {
        List<Fruit> list = Fruit.getList();
        String collect = list.stream().map(Fruit::getName).collect(Collectors.joining(",", "(", "]"));
        System.out.println(collect);
    }

    /**
     * partitioningBy(根据key是Boolean类型来分组)
     */
    @Test
    public void test7() {
        List<Fruit> list = Fruit.getList();
        Map<Boolean, List<Fruit>> listMap = list.stream().collect(Collectors.partitioningBy(fruit -> fruit.getName().equals("apple")));
        System.out.println(listMap);

    }

    /**
     * Function andThen
     */
    @Test
    public void test8() {
        Integer result = t8(5, x -> x * 2, x -> x * 3);
        System.out.println(result);
    }

    public Integer t8(Integer i, Function<Integer, Integer> fun1, Function<Integer, Integer> fun2) {
        Integer t = fun1.andThen(fun2).apply(i);
        return t;
    }


}
