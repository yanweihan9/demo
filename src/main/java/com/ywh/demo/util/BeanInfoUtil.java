package com.ywh.demo.util;

import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author: 颜伟晗
 * @date: 2019/2/20
 * @Description:
 */
public class BeanInfoUtil {
    public static void setProperty(Object o, String fieldName, Object value) throws Exception {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, o.getClass());
        Method writeMethod = propertyDescriptor.getWriteMethod();
        writeMethod.invoke(o, value);
    }

    public static Object getProperty(Object o, String fieldName) throws Exception {
        if (StringUtils.isEmpty(o) || StringUtils.isEmpty(fieldName)) {
            return null;
        }
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, o.getClass());
        Object invoke = propertyDescriptor.getReadMethod().invoke(o);
        return propertyDescriptor == null ? null : invoke;
    }


}
