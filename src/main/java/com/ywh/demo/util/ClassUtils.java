package com.ywh.demo.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

/**
 * @author: 颜伟晗
 * @date: 2019/2/20
 * @Description:
 */
public class ClassUtils {

    /**
     * 获取所有的属性
     * @param c
     * @return
     */
    public static List<Field> getAllFields(Class c) {
        if (c == null) {
            return Collections.emptyList();
        }
        List<Field> fields = new ArrayList<>();
        while (!c.isAssignableFrom(Object.class)) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
            c = c.getSuperclass();
        }
        return fields;
    }

    public static List<Field> getfilterFields(Class c, Predicate<Field> predicate) {
        return getAllFields(c).stream().filter(predicate).collect(toList());
    }

}
