package com.xiao.java8.lambda.news.pakgs;

/**
 * @author lktbz
 * @description: 没有参数的lambda   表达式学习
 * @date 2021/11/25
 */
public class LambdaExpressionExample {
    public static void main(String[] args) {
        /**
         * 定义执行的函数
         */
        MessageSevice ms=   ()->{
            return "hello";
        };
        /**
         *  函数调用
         */
        System.out.println(ms.getMessage());
    }
}

/**
 * 定义一个无参数的函数式接口
 */
@FunctionalInterface
interface MessageSevice{
    // method with no parameter
    public String getMessage();
}

