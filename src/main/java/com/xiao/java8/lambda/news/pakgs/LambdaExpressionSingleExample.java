package com.xiao.java8.lambda.news.pakgs;

/**
 * @author lktbz
 * @description: 单参数
 * @date 2021/11/25
 */
public class LambdaExpressionSingleExample {
    public static void main(String[] args) {
        //执行函数
        MessageServices ms= msg -> {
            return msg.toLowerCase();
        };
        System.out.println(ms.lowerCaseMsg("HELLO WORLD"));
    }
}

/**
 * 根据传入的参数，返回相应的值
 */
@FunctionalInterface
interface MessageServices {
    //method with single parameter
    public String lowerCaseMsg(String msg);
}