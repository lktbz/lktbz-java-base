package com.xiao.java8.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        /**
         * 对象的获取三种方式
         */
        Class<Programmer> aClass = Programmer.class;

//        Programmer programmer = new Programmer();
//        Class<? extends Programmer> aClass1 = programmer.getClass();
//        Class<?> aClass2 = Class.forName("com.xiao.java8.reflect.TestReflect");
//        /**
//         * 实例化对象
//         */
//        Programmer newInstance = aClass.newInstance();

        /**
         * 构造函数获取
         默认构造
         */
//        Constructor<Programmer> constructor = aClass.getConstructor();
//        System.out.println(constructor.getName());
        /**
         * 有参数
         */
//        Constructor<Programmer> constructor1 = aClass.getConstructor(String.class);
//        System.out.println(constructor1.getName());
        /**
         * 获得私有化构造函数
         */
//        Constructor<Programmer> declaredConstructor = aClass.getDeclaredConstructor(int.class);
        /**
         * 允许获取私有
         */
//        declaredConstructor.setAccessible(true);
//        /**
//         * 构建实例
//         */
//        Programmer programmer1 = declaredConstructor.newInstance(10);
//        System.out.println(programmer1);
//
//        /**
//         * 获取构造函数中的注解
//         */
//        Annotation[] declaredAnnotations = declaredConstructor.getAnnotations();
//        for (Annotation s:declaredAnnotations
//             ) {
//            System.out.println("构造函数中的注解为"+s);
//        }
        /**
         * 获取方法
         */
        Method[] methods = aClass.getDeclaredMethods();
        for (Method m:methods
             ) {
            System.out.println("反射的方法是"+m);
        }
        /**
         * 获取成员变量的注解
         *
         */
//        Field[] fields = aClass.getDeclaredFields();
//        for (Field declaredField : fields) {
//            ProGender fieldAnnotation = declaredField.getDeclaredAnnotation(ProGender.class);
//            if(fieldAnnotation != null){
//                Class<?> type = declaredField.getType();
//                System.out.println("类型是"+type);
//                AnnotatedType annotatedType = declaredField.getAnnotatedType();
//                System.out.println("annotatedType is"+annotatedType.getType());
//                System.out.println("字段"+ declaredField.getName()
//                        +"有注解，注解的value值是："+fieldAnnotation.gender());
//            } else {
//                System.out.println("字段"+declaredField.getName()+"没有注解");
//            }
//
//
//        }

    }
}
