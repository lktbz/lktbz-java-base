package com.xiao.java8.lambda;

import java.util.stream.IntStream;

/**
 * @ClassName Demo01
 * @Description lambda 顺序并发执行支持
 * @Author lktbz
 * @Date 2021/1/18
 */
public class Demo01 {

    public static void main(String[] args) {
        System.out.println("真与假：" + isPrime(5));
        System.out.println("真与假：" + isPrime(6));
        System.out.println("真与假：" + isPrime2(6));
        System.out.println("真与假：" + isPrime2(7));
        System.out.println("真与假：" + isPrime3(6));
        System.out.println("真与假：" + isPrime3(7));
    }

    /**
     * 传统方式
     * 输入的数字，必须大于2，and 除以2 后，没有余数则为false 反正true
     *
     * @param number
     *
     * @return
     */
    private static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    /**
     * 三元运算符修改
     *
     * @param number
     *
     * @return
     */
    private static boolean isPrime2(int number) {
        if (number < 2) return false;

        for (int i = 2; i < number; i++) {
            return number % i == 0 ? false : true;
        }
        return true;
    }

    /**
     * 同时处理这两种情况
     */
    private static boolean isPrime3(int number) {
        return number > 1
                && IntStream.range(2, number)
                .noneMatch(index -> number % index == 0);
    }

}
