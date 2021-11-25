package com.xiao.java8.reflect.formal;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description 字段
 * @Author lktbz
 * @Date 2021/06/25
 */
public class FieldDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
        Class<Supper> supperClass = Supper.class;
        Supper supper = supperClass.newInstance();
        Method sayHello = supperClass.getDeclaredMethod("sayHello");
        sayHello.setAccessible(Boolean.TRUE);
        //拿到字段设置值
        Field name = supperClass.getDeclaredField("name");
        name.setAccessible(true);
        //字段设置值
        name.set(supper,"lktbz");
        //获取字段值
        System.out.println("Field get-->"+name.get(supper));
        //获取方法
        sayHello.invoke(supper);

        name.set(supper, "lktbz-10086");
        System.out.println("Field get-->" + name.get(supper));
        sayHello.invoke(supper);
    }
    public static class Supper {

        private String name;

        private void sayHello() {
            System.out.println(String.format("%s say hello!", name));
        }
    }

}
