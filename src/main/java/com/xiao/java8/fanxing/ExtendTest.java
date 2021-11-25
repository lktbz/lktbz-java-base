package com.xiao.java8.fanxing;

import java.io.IOException;

public class ExtendTest {
    static class Food {}
    static class Fruit extends Food {}
    static class Apple extends Fruit {}

    public static void main(String[] args) throws IOException {
//        /**        <--fruit  <--apple
//         *   food
//         *       --
//         *
//         * /
//        协变：子类能向父类转换 Animal a1=new Cat();
//        逆变: 父类能向子类转换 Cat a2=(Cat)a1;
//        不变: 两者均不能转变
//        泛型中 ? 可以用来做通配符，单纯 ? 匹配任意类型。< ? extends T >
//        表示类型的上界是 T，参数化类型可能是 T 或 T 的子类：
//        协变泛型

//        List<? extends Fruit> fruits = new ArrayList<>();
//        fruits.add(new Food());     // compile error
//        fruits.add(new Fruit());    // compile error
//        fruits.add(new Apple());    // compile error
//
//        fruits = new ArrayList<Fruit>(); // compile success
//        fruits = new ArrayList<Apple>(); // compile success
//        fruits = new ArrayList<Food>(); // compile error
//        fruits = new ArrayList<? extends Fruit>(); // compile error: 通配符类型无法实例化
//
//        Fruit object = fruits.get(0);    // compile success


//        List<? super Fruit> fruits = new ArrayList<>();
//        fruits.add(new Food());     // compile error
//        fruits.add(new Fruit());    // compile success
//        fruits.add(new Apple());    // compile success
//
//        fruits = new ArrayList<Fruit>(); // compile success
//        fruits = new ArrayList<Apple>(); // compile error
//        fruits = new ArrayList<Food>(); // compile success
//        fruits = new ArrayList<? super Fruit>(); // compile error: 通配符类型无法实例化
//
//        Fruit object = fruits.get(0); // compile error
    }
         }
