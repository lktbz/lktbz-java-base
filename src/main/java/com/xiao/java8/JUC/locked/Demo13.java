package com.xiao.java8.JUC.locked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Demo13
 * @Description TODO
 * @Author lktbz
 * @Date 2021/1/12
 *
 * 需求：
 * 跑三个线程去列表中，获取数据，前提条件，必须拿到锁
 * ，
 */
public class Demo13 {

    public static  Lock lock=new ReentrantLock();
//    public static Lock lock=new ReentrantLock(true);

    public  static int getIds(List list){
//            加锁
            System.out.println("线程id" + Thread.currentThread().getId() + "-->name" + Thread.currentThread().getName() + "尝试获取锁");
//            lock.tryLock();
             lock.lock();
        try{
            System.out.println("线程id" + Thread.currentThread().getId() + "-->name" + Thread.currentThread().getName() + "获取锁");
            //模拟查数据库返回数据
            return (int)list.get(0);
        }finally {
            System.out.println("线程id" + Thread.currentThread().getId() + "-->name" + Thread.currentThread().getName() + "释放锁");
            lock.unlock();
        }

    }

    /**
     * 重入锁的其他用法
     */
    public  void otherMethod(){

    }
    public static void main(String[] args) {
      List<Integer>list= Arrays.asList(1,2,3,4,5,6);
        for (int i = 0; i <20 ; i++) {
            new Thread(()->{
             int ids=getIds(list);
                System.out.println(Thread.currentThread().getName()+"获取的值为"+ids);
            },"zs").start();
            new Thread(()->{
                int ids=getIds(list);
                System.out.println(Thread.currentThread().getName()+"获取的值为"+ids);
            },"lisi").start();
            new Thread(()->{
                int ids=getIds(list);
                System.out.println(Thread.currentThread().getName()+"获取的值为"+ids);
            },"wangwu").start();
        }
    }
}
