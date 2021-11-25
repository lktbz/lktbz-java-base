package com.xiao.java8.lambda.news.pakgs;

/**
 * @author lktbz
 * @description: 多参数
 * @date 2021/11/25
 */
public class LambdaExpressionMultiExample {
    public static void main(String[] args) {
        MessageServicess mss=(m1,m2)->m1.concat(m2);
        System.out.println(mss.concatinateMsg("lktbz","xiao"));
    }
}
@FunctionalInterface
interface MessageServicess {
    //method with multi parameter
    public String concatinateMsg(String msg1, String msg2);
}