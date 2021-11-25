package com.xiao.java8.JUC.locked;


import java.util.concurrent.*;

/**
 * @ClassName Demo18
 * @Description java线程执行结果
 * @Author lktbz
 * @Date 2021/1/14
 */
public class Demo18 {
    /**
     * 在创建线程时，不管 Thread 或者runnable 都无法得知程序 运行的结果、
     * 这时需要一个来支持，就是callable
     *  函数式接口
     *     V call() throws Exception;
     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task=new Task();
        Future<Integer> result = executor.submit(task);
        executor.shutdown();
        //获取结果
        while (!result.isDone()){
            Integer integer = result.get();
            System.out.println(integer);
        }
    }
    /**
     * 实现接口，返回一个Integer 对象
     */
    static  class  Task implements Callable{
        @Override
        public Integer call() throws Exception {
            System.out.println("子线程在进行计算");
            Thread.sleep(3000);
            int sum = 0;
            for(int i=0;i<100;i++)
                sum += i;
            return sum;
        }
    }
}
