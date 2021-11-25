package com.xiao.java8.JUC;



import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: lktbz
 * @Date: 2019/7/26 17:35
 * @Description:
 */
public class ExecutorServiceDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newScheduledThreadPool(4);
        service.submit(new Task());
        service.submit(new Task());
        service.submit(new LongTask());
        service.submit(new Task());
        service.shutdown();
        while(!service.awaitTermination(1,TimeUnit.SECONDS)){
            System.out.println("线程池没有关闭");
        }
        System.out.println("线程池已经关闭");
    }
    static class  Task implements Callable{

        @Override
        public Object call() throws Exception {
            System.out.println("普通信息正在执行。。。");
            return null;
        }
    }
    static class LongTask implements Callable{
        @Override
        public Object call() throws Exception {
            System.out.println("长时间任务，让他执行5分钟");
            TimeUnit.SECONDS.sleep(5);

            return null;
        }
    }
}
