package com.xiao.java8.fanxing.深入学习;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Demo06
 * @Description 例子
 * @Date 2021/6/5
 * @Created by lktbz
 */
public class Demo06 {



    public  static  abstract class Animal {
        public abstract void sing(Perform p);
    }
    public  static class Cat extends Animal {
        @Override
        public void sing(Perform p) {
            System.out.println("Hello, audience, I'm a Cat.");
        }
    }
    public static class Dog extends Animal {
        @Override
        public void sing(Perform p) {
            System.out.println("Hello, audience, I'm a dog.");
        }
    }
    public static  class Perform {
        //遍历
//        public void perform(List<Animal> animals) {
//            for (Animal a : animals) {
//                a.sing(this);
//            }
//        }
//        因为报错，所以修改遍历时的范围
//        public void perform(List<?> animals) {
//            for (Object a : animals) {
//                Animal aa =(Animal)a;
//                aa.sing(this);
//            }
//        }

        /**
         * 上面的存在的问题是：加了？引起了强制类型转换
         * @param animals
         *
         * 传递的List 类型可以为animal 或者animal的子类
         */
        public void perform(List<? extends Animal> animals) {
            for (Animal a : animals) {
                a.sing(this);
            }
        }
        /**
         * 使用 extends 添加数据
         */
//        public  void add(List<? extends Animal> animals){
////            animals.add(new Cat()); 报错，一脸懵逼，
//        }
        public  void add(List<? super Animal> animals){
            animals.add(new Cat());
        }
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        Perform perform=new Perform();
        dogs.add(new Dog());
        perform.perform(dogs);//报错，现在是拿数据进行操作

    }
}
