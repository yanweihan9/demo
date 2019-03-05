package com.ywh.demo.service;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author: 颜伟晗
 * @date: 2019/3/5
 * @Description:
 */
public class FiboCollector implements Collector<Integer,List<Integer>,List<Integer>> {
    @Override
    public Supplier<List<Integer>> supplier() {
        return () -> {
            List<Integer> result = new ArrayList<>();
            result.add(0); result.add(1);
            return result;
        };
    }

    @Override
    public BiConsumer<List<Integer>, Integer> accumulator() {
        return (res, num) -> {
            Integer next = res.get(res.size()-1) + res.get(res.size()-2);
            res.add(next);
        };
    }

    @Override
    public BinaryOperator<List<Integer>> combiner() {
        return null;
        //return (left, right) -> { left.addAll(right); return left; };
    }

    @Override
    public Function<List<Integer>, List<Integer>> finisher() {
        return res -> { res.remove(0);  return res; };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
    public static void main(String[] args){
        List<Integer> fibo = Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream().collect(new FiboCollector());
        System.out.println(fibo);
    }
}
