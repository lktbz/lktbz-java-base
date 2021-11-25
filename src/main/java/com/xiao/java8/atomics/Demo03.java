package com.xiao.java8.atomics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * @ClassName Demo03
 * @Description 并发修改
 * @Author lktbz
 * @Date 2021/1/15
 */
public class Demo03 {
    public  static  LongAdder adder=new LongAdder();
    public static void main(String[] args) {
        adder.add(10);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i <10 ; i++) {
            executorService.execute(new OneDemo(adder));
            executorService.execute(new TwoDemo(adder));
        }

        for (int i = 0; i < 10; i++) {
            new Thread(adder::increment).start();
            new Thread(adder::increment).start();
            new Thread(adder::increment).start();
        }



        executorService.shutdown();
    }
    static class OneDemo implements Runnable{
       private  LongAdder adder;

        public OneDemo(LongAdder adder) {
            this.adder = adder;
        }

        @Override
        public void run() {
            adder.increment();
            print();
        }
    }
    static class TwoDemo implements Runnable{
        private  LongAdder adder;

        public TwoDemo(LongAdder adder) {
            this.adder = adder;
        }

        @Override
        public void run() {
            adder.decrement();
            print();
        }
    }
    public static  void print(){
        System.out.println("addr"+adder);
    }
}
