package com.xiao.java8.reflect.formal;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @Description 参数类
 * @Author lktbz
 * @Date 2021/06/25
 */
public class ParameterDemo {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Supper> supperClass = Supper.class;
        Method name = supperClass.getDeclaredMethod("sayHello", String.class);
        name.setAccessible(true);
        for (Parameter parameter : name.getParameters()) {
            System.out.println("isNamePresent->" + parameter.isNamePresent());
            System.out.println("isImplicit->" + parameter.isImplicit());
            System.out.println("getName->" + parameter.getName());
            System.out.println("=====================");
        }
    }
    public static class Supper {
        private void sayHello(String name) {
            System.out.println(String.format("%s say hello!", name));
        }
    }
}
