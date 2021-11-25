package com.xiao.java8.JUC.locked;

import java.util.Random;

/**
 * @ClassName Demo05
 * @Description synchronized 静态方法锁
 * @Author lktbz
 * @Date 2021/1/10
 */
public class Demo05 {
    private static int c=0;

    /**
     * 静态方法锁
     */
    public static synchronized void increment() {
        System.out.println("线程："+Thread.currentThread().getName()+"；获取了锁");
        c++;
        new Demo05().getValue();

    }
    private  void getValue(){
        System.out.println("c 的值为"+c);
    }

    public static void main(String[] args) {


        Random random=new Random();
        for (int i = 0; i <50 ; i++) {
                new  Thread(()->{
                    Demo05.increment();
                    System.out.println("线程："+Thread.currentThread().getName()+"；释放了锁");
                },"王五").start();
                new  Thread(()->{
                    Demo05.increment();
                    System.out.println("线程："+Thread.currentThread().getName()+"；释放了锁");
                },"lisi").start();
                new  Thread(()->{
                    Demo05.increment();
                    System.out.println("线程："+Thread.currentThread().getName()+"；释放了锁");
                },"jkdfk").start();
                new  Thread(()->{
                    Demo05.increment();
                    System.out.println("线程："+Thread.currentThread().getName()+"；释放了锁");
                },"zs").start();
                new  Thread(()->{
                    Demo05.increment();
                    System.out.println("线程："+Thread.currentThread().getName()+"；释放了锁");
                },"wf").start();
        }
        /**
         * 执行java p 看下字节码
         * public class com.xiao.locked.Demo05 {
         *   public com.xiao.locked.Demo05();
         *     Code:
         *        0: aload_0
         *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         *        4: return
         *
         *   public static synchronized void increment();
         *     Code:
         *        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         *        3: new           #3                  // class java/lang/StringBuilder
         *        6: dup
         *        7: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
         *       10: ldc           #5                  // String 线程：
         *       12: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
         *       15: invokestatic  #7                  // Method java/lang/Thread.currentThread:()Ljava/lang/Thread;
         *       18: invokevirtual #8                  // Method java/lang/Thread.getName:()Ljava/lang/String;
         *       21: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
         *       24: ldc           #9                  // String ；获取了锁
         *       26: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
         *       29: invokevirtual #10                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
         *       32: invokevirtual #11                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         *       35: getstatic     #12                 // Field c:I
         *       38: iconst_1
         *       39: iadd
         *       40: putstatic     #12                 // Field c:I
         *       43: new           #13                 // class com/xiao/locked/Demo05
         *       46: dup
         *       47: invokespecial #14                 // Method "<init>":()V
         *       50: invokespecial #15                 // Method getValue:()V
         *       53: return
         *
         *   public static void main(java.lang.String[]);
         *     Code:
         *        0: new           #18                 // class java/util/Random
         *        3: dup
         *        4: invokespecial #19                 // Method java/util/Random."<init>":()V
         *        7: astore_1
         *        8: iconst_0
         *        9: istore_2
         *       10: iload_2
         *       11: bipush        30
         *       13: if_icmpge     94
         *       16: aload_1
         *       17: iconst_3
         *       18: invokevirtual #20                 // Method java/util/Random.nextInt:(I)I
         *       21: istore_3
         *       22: iload_3
         *       23: ifne          46
         *       26: new           #21                 // class java/lang/Thread
         *       29: dup
         *       30: invokedynamic #22,  0             // InvokeDynamic #0:run:()Ljava/lang/Runnable;
         *       35: ldc           #23                 // String 王五
         *       37: invokespecial #24                 // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;Ljava/lang/String;)V
         *       40: invokevirtual #25                 // Method java/lang/Thread.start:()V
         *       43: goto          88
         *       46: iload_3
         *       47: iconst_1
         *       48: if_icmpne     71
         *       51: new           #21                 // class java/lang/Thread
         *       54: dup
         *       55: invokedynamic #26,  0             // InvokeDynamic #1:run:()Ljava/lang/Runnable;
         *       60: ldc           #27                 // String lisi
         *       62: invokespecial #24                 // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;Ljava/lang/String;)V
         *       65: invokevirtual #25                 // Method java/lang/Thread.start:()V
         *       68: goto          88
         *       71: new           #21                 // class java/lang/Thread
         *       74: dup
         *       75: invokedynamic #28,  0             // InvokeDynamic #2:run:()Ljava/lang/Runnable;
         *       80: ldc           #29                 // String zs
         *       82: invokespecial #24                 // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;Ljava/lang/String;)V
         *       85: invokevirtual #25                 // Method java/lang/Thread.start:()V
         *       88: iinc          2, 1
         *       91: goto          10
         *       94: return
         *c
         *   static {};
         *     Code:
         *        0: iconst_0
         *        1: putstatic     #12                 // Field c:I
         *        4: return
         * }
         */
    }
}
