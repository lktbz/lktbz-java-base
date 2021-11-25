package com.xiao.java8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * 实战环节
 * 假如现在有如下需求：
 * 现有一个包含了各种颜色不同重量的苹果的List，编写一个方法，从中筛选出满足要求的苹果。
 * 比如筛选出红色的苹果、红色并且重量大于1kg的苹果、绿色重量小于0.5kg的苹果或者红色大于0.5kg的苹果等等
 */
public class Lambda02 {

    /**
     * 筛选苹果
     */
    public  static List<Apple> filterApple(List<Apple>list, AppleFilter filter){
        List<Apple>apples=new ArrayList<Apple>();
        for (Apple apple:list){
            apples.add(apple);
        }
        return apples;
    }

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<Apple>();
        appleList.add(new Apple("red", 0.4));
        appleList.add(new Apple("red", 0.6));
        appleList.add(new Apple("red", 1.3));
        appleList.add(new Apple("green", 0.2));
        appleList.add(new Apple("green", 0.35));
        appleList.add(new Apple("green", 1.1));

        /**
         * 筛选出红色的apple
         */
//        List<Apple> appleLista = Lambda02.filterApple(appleList, (apple) -> "red".equalsIgnoreCase(apple.getColor()));
//        for (Apple apple:appleLista){
//            System.out.println("苹果的颜色是"+apple.getColor()+"苹果的重量是"+apple.getWeight());
//        }
       /** 筛选出红色并且重量大于1kg的苹果:**/
//        List<Apple> appleFilterList = Lambda02.filterApple(appleList,
//                (apple) -> "red".equalsIgnoreCase(apple.getColor()) && apple.getWeight() > 1.0);
//        for (Apple apple : appleFilterList) {
//            System.out.println(apple.getColor() + " apple,weight:" + apple.getWeight());
//        }

        /**筛选出绿色重量小于0.5kg的苹果或者红色大于0.5kg的苹果:**/
//        List<Apple> appleFilterList = Lambda02.filterApple(appleList,
//                (apple) -> ("green".equalsIgnoreCase(apple.getColor()) && apple.getWeight() < 0.5) ||
//                        ("red".equalsIgnoreCase(apple.getColor()) && apple.getWeight() > 0.5));
//        for (Apple apple : appleFilterList) {
//            System.out.println(apple.getColor() + " apple,weight:" + apple.getWeight());
//        }
    }

}
