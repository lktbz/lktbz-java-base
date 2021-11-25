package com.xiao.java8.aysn.callback.task;

import java.util.concurrent.*;

/**
 * @author lktbz
 * @date 2021-06-17
 * @desc  异步执行 获取执行结果
 *
 */
public class FutureDemo {
    /**
     * callale

    public interface Callable<V> {
        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result

        V call() throws Exception;
    }
     根据官方demo,其是需要结合线程池进行使用
     */
    /**
     * // 获取异步执行 的结果
     * public interface Future<V> {
     *        取消任务
     *     boolean cancel(boolean mayInterruptIfRunning);
     *     是否取消
     *     boolean isCancelled();
     *     是否结束
     *     boolean isDone();
     *     获取任务执行的结果
     *     V get() throws InterruptedException, ExecutionException;
     *     相应时间内的等待获取结果
     *     V get(long timeout, TimeUnit unit)
     *         throws InterruptedException, ExecutionException, TimeoutException;
     * }
     *
     */
    public static void main(String[] args) {
//        demo01();
        demo02();
    }
    //使用future 和callble
   public static void demo01(){
       ExecutorService service= Executors.newCachedThreadPool();
       Task task=new Task();
       Future<Integer> submit = service.submit(task);
       service.shutdown();
       try {
           Thread.sleep(1000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println(Thread.currentThread().getName()+"主线程正在执行任务");
       try {
           Integer integer = submit.get();
           System.out.println(Thread.currentThread().getName()+"task 运行的结果为："+integer);
       } catch (InterruptedException e) {
           e.printStackTrace();
       } catch (ExecutionException e) {
           e.printStackTrace();
       }
       System.out.println(Thread.currentThread().getName()+"end....");
   }
   //使用futureTask 和callable
    public static void demo02(){
        ExecutorService service= Executors.newCachedThreadPool();
        Task task=new Task();
        FutureTask<Integer> futureTask=new FutureTask<Integer>(task);
        service.submit(futureTask);
        service.shutdown();
    }
   //这就是定义了一个可执行的任务类
   static class Task implements Callable<Integer>{

       @Override
       public Integer call() throws Exception {
           System.out.println( Thread.currentThread().getName()+"子线程正在进行计算");
           Thread.sleep(3000);
           int sum=0;
           for (int i = 0; i <100 ; i++) {
               sum+=i;
           }
           System.out.println(Thread.currentThread().getName()+"子线程结束运算");
           return sum;
       }
   }
}
