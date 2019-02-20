package com.ywh.demo;

import com.ywh.demo.model.LevelType;
import com.ywh.demo.model.UserInfo;
import com.ywh.demo.util.BeanInfoUtil;
import com.ywh.demo.util.ClassUtils;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author: 颜伟晗
 * @date: 2019/2/20
 * @Description: 打印输出所有带@LevelType注解的成员变量的值
 */
public class AnnotationTest {

    public static void main(String[] args) throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("ywh");
        userInfo.setOnelevel("等级一");
        userInfo.setTwolevel("等级二");
        List<Field> fields = ClassUtils.getfilterFields(
                userInfo.getClass(), field -> field.getAnnotation(LevelType.class) != null);
        fields.forEach(field -> {
            LevelType annotation = field.getAnnotation(LevelType.class);
            //获取注解的code
            String code = annotation.key().getCode();
            //获取成员变量名
            String name = field.getName();
            Object userName = null;
            try {
                userName = BeanInfoUtil.getProperty(userInfo, name);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(userName);
        });

    }
}
