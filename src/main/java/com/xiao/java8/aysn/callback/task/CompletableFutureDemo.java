package com.xiao.java8.aysn.callback.task;

import org.junit.Test;
import org.springframework.util.ObjectUtils;

import java.util.concurrent.*;

/**
 * @author lktbz
 * @date 2021-06-17
 *    java 8 后新异步方式
 */
public class CompletableFutureDemo {
    /**
     * 构建CompletableFuture 方式 ：没有返回值
     */
    @Test
    public void testCreate01() throws ExecutionException, InterruptedException {
        //
        CompletableFuture<Void> future=CompletableFuture.runAsync(
                ()-> System.out.println("lala")
        );
        Object o = future.get();
        if(ObjectUtils.isEmpty(o)){
            System.out.println("没有数据被返回");
        }
//        CompletableFuture.supplyAsync();
    }

    /**
     * 构建CompletableFuture 方式 ：带有返回值的
     */
    @Test
    public void testCreate02() throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> "jaja");
       //使用阻塞方式获取异步执行结果，并返回
        System.out.println(stringCompletableFuture.get());
    }

    /**
     * 使用线程池
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void testCreateByThreadPool() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        //线程池放进去
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() ->{
            try {
                System.out.println(Thread.currentThread().getName()+"准备执行");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "处理任务完毕，返回";
        },service);

        //使用阻塞方式获取异步执行结果，并返回
        System.out.println(Thread.currentThread().getName()+"--"+"是够正在执行呢？。。。");
        System.out.println(Thread.currentThread().getName()+"--"+stringCompletableFuture.get());
        /**
         * 执行结果
         * main--是够正在执行呢？。。。
         * pool-1-thread-1准备执行
         * pool-1-thread-1执行完毕
         * main--处理任务完毕，返回
         */
    }
    /**
     * 通过上面的例子，都需要get 阻塞线程来实现，这显然，不符合预期，
     * 现在希望能够有返回结果时，传入到下面的方法，从而解放主线程
     *
     * thenApply 用法，带返回
     */
    @Test
    public void testThenApply() throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            //返回name
            return "lktbz";
        });
        CompletableFuture<String> stringCompletableFuture1 = stringCompletableFuture.thenApply((s) -> {
            return s + ":=zs";
        });
//        获取两个业务执行的结果
        System.out.println(stringCompletableFuture1.get());
    }

    /**
     * fluent api 写法 ，带返回
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void testThenApply02() throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            //返回name
            return "lktbz";
        }).thenApply((name)-> {return name+" lla";})
          .thenApply(greeting ->{
              return greeting + ", Welcome to the CalliCoder Blog";
          });
        System.out.println("链式写法：="+stringCompletableFuture.get());

    }

    /**
     * 不需要返回结果 thenAccept() 和 thenRun()方法
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void testThenAccept() throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(()->{
            Lktbz lktbz=new Lktbz("xiao","BJ");
            return lktbz;
            //thenaccept 可以接受一个返回结果
        }).thenAccept(ls->{
            System.out.println("获取到的地址为"+ls.getAddress());
        });
    }

    /**
     * 此方法不能接收上一个任务的返回参数
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void testThenRun() throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(() -> {
            Lktbz lktbz = new Lktbz("xiao", "BJ");
            return lktbz;
            //thenaccept 可以接受一个返回结果
        }).thenRun(() -> {
            try {
                //模拟处理任务
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run 执行完毕。。。");
        });
    }

    /**
     * 测试传参数 ,直接报错
     * @throws ExecutionException
     * @throws InterruptedException
     */
//    @Test
//    public void testThenRun2() throws ExecutionException, InterruptedException {
//        CompletableFuture.supplyAsync(() -> {
//            Lktbz lktbz = new Lktbz("xiao", "BJ");
//            return lktbz;
//            //thenaccept 可以接受一个返回结果
//        }).thenRun((s) -> {
//            try {
//                //模拟处理任务
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("run 执行完毕。。。");
//        });
//    }
//
//   两个线程去分别异步执行而不等待上一个线程的执行结果
    @Test
    public void testThenApplyAsyn(){
        CompletableFuture.supplyAsync(()->{
            return "ss";
        }).thenApplyAsync(s-> s+"Processed Result").thenAccept(sv->{
            System.out.println(sv);
        });
    }

    /**
     * 组合两个不同的future
     */
    /**
     * 现在有两个需求
     * 一个是查询用户的地址，一个是查询用户名
     */
    @Test
    public void test01(){
        //两个执行过程
        CompletableFuture<String> stringAddress = CompletableFuture.supplyAsync(() -> {
           //todo
            //模拟查询出地址
            return "Beijing";
        });
        CompletableFuture<String> stringName = CompletableFuture.supplyAsync(() -> {
            //todo
            //模拟查询name
            return "lktbz";
        });
    }

    /**
     * 过程融合
     */
    @Test
    public void test02() throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            //模拟查询出地址
            return "Beijing";
        }).thenApply(s -> {
            return s + "+=lktbz";
        });
        System.out.println("两个业务获取的到值为"+stringCompletableFuture.get());
    }

    /**
     *  模拟业务操作一：
     * @param name
     * @return
     */
    CompletableFuture<Lktbz> getUsersDetail(String name) {
        return CompletableFuture.supplyAsync(() -> {
         return  new Lktbz("zs","SH");
        });
    }

    /**
     * 模拟业务操作二：
     * @param user
     * @return
     */
    CompletableFuture<String> getCreditRating(Lktbz user) {
        return CompletableFuture.supplyAsync(() -> {
          return user.getAddress();
        });
    }

    /**
     * 组合 demo
     * 获取最终结果返回给最顶层
     */
    @Test
    public void testCompose(){
        getUsersDetail("lktbz").thenCompose((user)->getCreditRating(user));
    }

    /**
     * 虽然thenCompose()被用于当一个future依赖另外一个future的时候用来组合两个future。
     * thenCombine()被用来当两个独立的Future都完成的时候，用来做一些事情。
     */
    @Test
    public void testThenCombine() throws ExecutionException, InterruptedException {
        System.out.println("Retrieving weight.");
        CompletableFuture<Double> weightInKgFuture  = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 65.0;
        });
        System.out.println("Retrieving height.");
        CompletableFuture<Double> heightInCmFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 177.8;
        });
        System.out.println("Calculating BMI.");
        CompletableFuture<Double> combinedFuture = weightInKgFuture
                .thenCombine(heightInCmFuture, (weightInKg, heightInCm) -> {
                    Double heightInMeter = heightInCm/100;
                    return weightInKg/(heightInMeter*heightInMeter);
                });
        System.out.println("Your BMI is - " + combinedFuture.get());
        //当两个Future都完成的时候，传给``thenCombine()的回调函数将被调用
    }
    //组合多个CompletableFuture
    /**
     * 我们使用thenCompose() 和 thenCombine()把两个CompletableFuture组合在一起。
     * 现在如果你想组合任意数量的CompletableFuture，应该怎么做？
     * 我们可以使用以下两个方法组合任意数量的CompletableFuture
     * static CompletableFuture<Void> allOf(CompletableFuture<?>... cfs)
     * static CompletableFuture<Object> anyOf(CompletableFuture<?>... cfs)
     */
    @Test
    public void testThenAnyOf() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of Future 1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of Future 2";
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of Future 3";
        });

        CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1, future2, future3);

        System.out.println(anyOfFuture.get()); // Result of Future 2
    }

    /**
     * 异常处理方式
     *  使用 exceptionally() 回调处理异常
     */
    @Test
    public void exceptionDemo1() throws ExecutionException, InterruptedException {
        Integer age = -1;

        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
            if(age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }
            if(age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return "Unknown!";
        });

        System.out.println("Maturity : " + maturityFuture.get());

    }
    /**
     * 异常处理方式
     *  使用 handle() 回调处理异常
     */
    @Test
    public void exceptionDemo2() throws ExecutionException, InterruptedException {
        Integer age = -1;

        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
            if(age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }
            if(age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).handle((res, ex) -> {
            if(ex != null) {
                System.out.println("Oops! We have an exception - " + ex.getMessage());
                return "Unknown!";
            }
            return res;
        });

        System.out.println("Maturity : " + maturityFuture.get());
    }
    static class Lktbz{
        private String name;
        private String address;

        public Lktbz() {
        }

        public Lktbz(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "Lktbz{" +
                    "name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }
}
