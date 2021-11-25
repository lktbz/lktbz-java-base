package com.xiao.java8.foreach.demo;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author lktbz
 * @description: TODO
 * @date 2021/11/25
 */
public class IteratorConsumerDemo {
    public static void main(String[] args) {
        //定义基础数据
        List<String> list = List.of("Jhon", "Rob", "Albert");
         test01(list);
         test02(list);
         test03(list);
    }
    //With Consumer<T> instance
    public static void  test01(List<String> list){
        // 定义foreach 接受的消费者
        Consumer<String> consumer = new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println("接收到的数据为："+s);
            }
        };
//        遍历消费者
        list.forEach(consumer);
    }
    //lambda
    public  static void  test02(List<String> list){

        list.forEach(s-> System.out.println(s));
    }
    //方法引用
    public static void  test03(List<String> list){

        list.forEach(System.out::println);
    }
}
