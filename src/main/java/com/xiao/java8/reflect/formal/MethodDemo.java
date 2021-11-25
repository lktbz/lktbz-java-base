package com.xiao.java8.reflect.formal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description 方法级别反射demo
 * @Author lktbz
 * @Date 2021/06/25
 */
public class MethodDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Supper> supperClass = Supper.class;
        Supper supper = supperClass.newInstance();
        Method sayHello = supperClass.getDeclaredMethod("sayHello", String.class);
        sayHello.setAccessible(true);
        //调用方法
        sayHello.invoke(supper,"demo");
    }

    public static class Supper{

        private void sayHello(String name){
            System.out.println(String.format("%s say hello!", name));
        }
    }
}
