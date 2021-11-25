package com.xiao.java8.JUC.locked;

/**
 * @ClassName Demo02
 * @Description sleep 线程的sleep
 * @Author lktbz
 * @Date 2021/1/10
 */
public class ThreadSleepDemo02 {
    public static void main(String[] args) throws InterruptedException {
        String inport[]={
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };
        for (int i = 0; i <inport.length ; i++) {
//            暂停线程
            Thread.sleep(4000);
//            打印结果
            System.out.println(inport[i]);
        }
    }
}
