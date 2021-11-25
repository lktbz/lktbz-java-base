package com.xiao.java8.thrad.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Auther: lktbz
 * @Date: 2019/7/22 23:06
 * @Description: 创建线程的三种方式
 */
public class Test01 {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        RunThread thread1 = new RunThread();
        new Thread(thread1).start();

        FutureTask<String> futureTask = new FutureTask<>(new Calltask());
        new Thread(futureTask).start();
        try {
           String msg= futureTask.get();
            System.out.println("返回的结果为"+msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    /**
      第一种方式
     */
    public  static  class MyThread extends  Thread{
        @Override
        public void run() {
            System.out.println("线程名为："+Thread.currentThread().getName()+"我是子线程我正在运行。。。。");
        }
    }

    /**
     * 第二种方式
     */
    public static  class  RunThread implements  Runnable{

        @Override
        public void run() {
            System.out.println("方式二正在运行。。。。。"+Thread.currentThread().getName() );
        }
    }
    /**
     * 第三种方式
     */

    public  static class Calltask implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "hello我 执行完毕";
        }
    }
}
