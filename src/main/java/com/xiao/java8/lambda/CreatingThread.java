package com.xiao.java8.lambda;

/**
 * @ClassName CreatingThread
 * @Description TODO
 * @Author lktbz
 * @Date 2020/12/4
 */
public class CreatingThread {
    public static void main(String[] args) {
        Runnable withLambda = () -> System.out.println(" Runnable example with lambda exp.");
        Thread thread1 = new Thread(withLambda);
        thread1.start();
    }
}
