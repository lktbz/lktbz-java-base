package com.xiao.java8.JUC.locked;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName CyclicBarrierDemo01
 * @Description 并发工具类二： 栅栏
 * @Author lktbz
 * @Date 2021/1/14
   **
        通过其doc 可以知道：其使用特点是使线程到达某一个点，然后线程一起执行，任务结束，等待下一个点的到来

    举个例子：
    跟朋友喝酒：
        有人喝酒块，有人喝酒慢-->
                        当一个个拿起酒杯，准备碰杯时，需要等待都碰杯，然后在一起喝酒。

        一轮喝酒结束，
        继续循环
            还是会有下一轮的一起碰杯的栅栏点



 */
public class CyclicBarrierDemo01 {
    /**
     * 举例子 若干线程进行写数据操作，并且所有的线程必须等到都完成写数据操作之后，这些线程才能继续做后面的事情。
     *
     */
    public static void main(String[] args) {
        int N=4;
        CyclicBarrier cyclicBarrier=new CyclicBarrier(N);
        for (int i = 0; i <N ; i++) {
            new Writer(cyclicBarrier).start();
        }
    }
    static  class  Writer extends Thread{
       private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
            try {
                //模拟写入数据库操作
                Thread.sleep(5000);
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕...");
//                挂起
                cyclicBarrier.await();

            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }
}
