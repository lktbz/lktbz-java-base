package com.xiao.java8.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName MethodDemo
 * @Description 主要为了测试Method 的invoke 方法
 * @Author lktbz
 * @Date 2021/1/20
 */
public class MethodDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//      demo01();
        demo02();
    }

    /**
     * 通过指定的方法，执行相应的参数
     *
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static void demo01() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //反射
        Class<?> aClass = User.class;
        Object o = aClass.newInstance();
        //指定专门的方法，然后通过invoke调用方法
        Method sayHello = aClass.getDeclaredMethod("sayHello", null);
        sayHello.invoke(o);
    }

    /**
     * 不指定限定的方法。执行全部的方法？
     */
    public static void demo02() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> aClass = User.class;
        Object o = aClass.newInstance();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method m : declaredMethods
        ) {
            //user 类中放按方法，全部执行了
            m.invoke(o, null);
        }
    }
    static class User {
        public void sayHello() {
            System.out.println("您好，我被执行了");
        }

        public void sayName() {
            System.out.println("my name is  zs");
        }
    }
}
