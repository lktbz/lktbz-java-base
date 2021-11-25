package com.xiao.java8.fanxing;

import java.util.List;

/**
 * @Classname GenericProblems
 * @Description 泛型带来的问题
 * @Date 2021/6/4
 * @Created by lktbz
 */
public class GenericProblems {
    /**
     *上面这段代码，有两个重载的函数，因为他们的参数类型不同，一个是List<String>另一个是List<Integer> ，
     * 但是，这段代码是编译通不过的。因为我们前面讲过，
     * 参数List<Integer>和List<String>编译之后都被擦除了，
     * 变成了一样的原生类型List，擦除动作导致这两个方法的特征签名变得一模一样
     */
    public  static void method(List<Integer> list){
        System.out.println("invoke method(List<Integer> list)");
    }

//    public static void method(List<String>list){
//        System.out.println("invoke method(List<String> list)");
//    }
}
