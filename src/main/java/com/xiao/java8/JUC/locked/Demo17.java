package com.xiao.java8.JUC.locked;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Demo17
 * @Description 生产者消费者模型
 * @Author lktbz
 * @Date 2021/1/13
 */
public class Demo17 {
    public static void main( String[] args ){
        Queue<String> queue=new LinkedList<>();
        Lock lock=new ReentrantLock(); //重入锁
        Condition condition=lock.newCondition();
        int maxSize=5;
        Producer producer=new Producer(queue,maxSize,lock,condition);
        Consumer consumer=new Consumer(queue,maxSize,lock,condition);
        Thread t1=new Thread(producer);
        Thread t2=new Thread(consumer);
        t1.start();
        t2.start();
    }
}
