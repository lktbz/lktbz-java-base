package com.xiao.java8.reflect.formal;

/**
 * @Description 类的创建
 * @Author lktbz
 * @Date 2021/06/25
 */
public class CreateClassDemo {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Supper.class;
            Supper o = (Supper)aClass.newInstance();
            System.out.println(o.sayHello("lktbz"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
    public static class Supper {

        public String sayHello(String name) {
            return String.format("%s say hello!", name);
        }
    }
}
