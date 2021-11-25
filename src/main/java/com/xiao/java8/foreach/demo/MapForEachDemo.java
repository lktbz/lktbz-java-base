package com.xiao.java8.foreach.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author lktbz
 * @description: TODO
 * @date 2021/11/25
 */
public class MapForEachDemo {
    public static void main(String[] args) {
        Map<String,String> myMap = new HashMap<>();
        myMap.put("firstName","Arvind");
        myMap.put("lastName","Chandok");
        test01(myMap);
        test02(myMap);
        test03();
    }
    //BiConsumer<T,U> instance. 第一种遍历方式
    public static void  test01(Map<String,String> myMap){
        BiConsumer<String, String> biConsumer = new BiConsumer<>() {
            @Override
            public void accept(String key, String value) {
                System.out.println("map 遍历的对象key：" + key + " value: " + value);
            }
        };
        myMap.forEach(biConsumer);
    }
    //Lambda
    public static void  test02(Map<String,String> myMap){
       myMap.forEach((k,v)->{
           System.out.println(k+"="+v);
       });
    }
    //集合的无序性与有序性测试
    public static void  test03(){
        List<String> list2 = Arrays.asList("First", "Second", "Third", "Forth", "Fifth");
        System.out.println("Printing each element");
        list2.stream().forEach(System.out::println);

    }
}
