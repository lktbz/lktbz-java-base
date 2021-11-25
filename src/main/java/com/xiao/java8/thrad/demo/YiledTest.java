package com.xiao.java8.thrad.demo;

/**
 * @Auther: lktbz
 * @Date: 2019/7/23 20:59
 * @Description:
 */
public class YiledTest implements Runnable {
    public YiledTest() {
        Thread t =new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        //锁去掉，以及分别加入this ，YiledTest.class 起结果不一样
        synchronized (YiledTest.class){
            for (int i=0;i<5;i++){
                System.out.println("循环便利开始"+Thread.currentThread().getName());
                if((i%5==0)){
                    System.out.println(Thread.currentThread().getName()+"让出线程的执行权");
                    Thread.yield();
                }
                System.out.println("我正在执行中"+Thread.currentThread().getName());
            }
        }

        System.out.println("thread"+Thread.currentThread().getName()+" is over");
    }
    public static void main(String[] args) {
        new YiledTest();
        new YiledTest();
    }
}
