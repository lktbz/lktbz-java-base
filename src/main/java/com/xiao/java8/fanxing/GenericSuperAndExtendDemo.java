package com.xiao.java8.fanxing;

import java.util.List;

/**
 * @Classname GenericSuperAndExtendDemo
 * @Description 枚举中super 和extend 使用
 * @Date 2021/6/5
 * @Created by lktbz
 */
public class GenericSuperAndExtendDemo {
    /**
     * 数据准备
     */
    public class Food{}
    public class Fruit extends Food{}
    public class Apple extends Fruit{}
    public class Banana  extends Fruit{}

    public static void main(String[] args) {

    }

    public void testExtend(List<? extends Fruit> list){
//      list.add(new Apple());
        Fruit fruit = list.get(1);

    }
}
