package com.xiao.java8.collections;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname MapsDemo
 * @Description 阿里规范推荐map 遍历方式
 * @Date 2021/6/7
 * @Created by lktbz
 */
public class MapsDemo {
    public static void main(String[] args) {
        //根据阿里推荐的规范，遍历map 时使用entrySet 或者JDK 8 中的map.foreach
        Map<String ,String>maps=new HashMap<>();
        maps.put("d1","demo1");
        maps.put("d2","demo2");
        maps.put("d3","demo3");
        maps.put("d4","demo4");
        maps.put("d5","demo5");

        maps.forEach((s, s2) ->
                        System.out.println("遍历的key="+s+":value="+s2)
         );
        for (Map.Entry<String, String> stringStringEntry : maps.entrySet()) {
            System.out.println("entryset 的key为"+stringStringEntry.getKey()+"==value为"+stringStringEntry.getValue());
        }

    }
    @Test
    public  void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
            Map<String ,String>maps=new HashMap<>();
            maps.put("lktbs","lkss");
            Class<? extends Map> aClass = maps.getClass();
             Method capacities = aClass.getDeclaredMethod("capacity");
            capacities.setAccessible(true);
            System.out.println("capity"+capacities.invoke(maps));

            Field size = aClass.getDeclaredField("size");
         size.setAccessible(true);
            System.out.println("size : " + size.get(maps));


    }
}
