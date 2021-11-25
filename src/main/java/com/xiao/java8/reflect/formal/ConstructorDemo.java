package com.xiao.java8.reflect.formal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Description 构造创建对象
 * @Author lktbz
 * @Date 2021/06/25
 */
public class ConstructorDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Supper> supperClass = Supper.class;
        Constructor<Supper> declaredConstructor = supperClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Supper supper = declaredConstructor.newInstance();
        supper.sayHello("as");
    }
    private static class Supper {

        public void sayHello(String name) {
            System.out.println(String.format("%s say hello!", name));
        }
    }
}
