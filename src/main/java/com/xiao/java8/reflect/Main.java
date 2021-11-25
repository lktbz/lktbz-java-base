package com.xiao.java8.reflect;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        // 反射获得 class
        Class<?> clazz = Class.forName("com.nf.lc.demo3.Product");
        // 如果类 Product 上有注解 @Alias ，取出注解 value的值
        Alias declaredAnnotation = clazz.getDeclaredAnnotation(Alias.class);
        if(declaredAnnotation != null){
            System.out.println("类Product的注解@Alias的value值是："+declaredAnnotation.value());
        }

        //获得所有该类方法，不包括从其他地方继承过来的
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field declaredField : declaredFields) {
            Alias fieldAnnotation = declaredField.getDeclaredAnnotation(Alias.class);
            if(fieldAnnotation != null){
                System.out.println("字段"+ declaredField.getName()
                        +"有注解，注解的value值是："+fieldAnnotation.value()
                        +" 注解的isGenerator的值是："+fieldAnnotation.isGenerator());
            } else {
                System.out.println("字段"+declaredField.getName()+"没有注解");
            }


        }


    }

}
