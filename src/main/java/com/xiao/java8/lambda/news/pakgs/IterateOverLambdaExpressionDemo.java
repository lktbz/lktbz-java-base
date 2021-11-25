package com.xiao.java8.lambda.news.pakgs;

import java.util.Arrays;
import java.util.List;

/**
 * @author lktbz
 * @description: 遍历
 * @date 2021/11/25
 */
public class IterateOverLambdaExpressionDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("First","Second","Third");
//        普通的for循环
        for (String s : list) {
            System.out.println(s);
        }

//        lambda 循环
        list.forEach(s->{System.out.println(s);});

    }
}
