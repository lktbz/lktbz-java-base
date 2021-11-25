package com.xiao.java8.exceptions;

import org.junit.Test;

/**
 * @Description java 异常深入分析
 * @Author lktbz
 * @Date 2021/07/11
 */
public class ExceptionDemo {
    /**
     *  异常的简单实例
     */
    @Test
    public void  demo01(){
        int a=10;
        int b=0;
        try {
            System.out.println(a/b);
        } catch (Exception e) {
            System.out.println("程序出错") ; //优雅的结束掉程序，后续程序还会接着运行。。。
//            throw new RuntimeException("我想抛个运行时异常。");  处理异常的时候在抛出异常。。。
        }
        System.out.println("你是否还在执行。。。");
    }

    /**
     *   抛出一个自定义异常，
     */
    @Test
    public void  demoimprove(){
        int a=10;
        int b=0;
        try {
            System.out.println(a/b);
        } catch (Exception e) {
           new MyException("我就是来运行的，。，。",200); //成功的将异常吃掉了。。。。。
        }
        System.out.println("你是否还在执行。。。");
    }

    /**
     *  多层catch，查看是父类还是子类抛异常
     *   执行结果子类抛了异常
     */
    @Test
    public void  demo02()  {
        int a=10;
        int b=0;
        try {
            System.out.println(a/b);
        } catch (  ArithmeticException e) {
            System.out.println("程序出错");
        }catch (Exception e){
            System.out.println("次顶级异常执行了");
        }
    }

    /**
     *  异常的不处理
     */
    @Test
    public void  demo03()  {
        int a=10;
        int b=0;
            System.out.println(a/b);
    }

    /**
     *  对变量的校验方式处理异常
     */
    @Test
    public void  demo04() throws Exception {
        int a=10;
//        int b=0;
        int b=1;
        if(b==0){throw new Exception("变量必须大于0");}
        System.out.println(a/b);
    }

    /**
     * 程序的多重错误处理方式
     *
     *
     *
     * 存在多个异常只会执行第一个抛的异常
     */
    @Test
    public void  demo05(){
        int arr[]=new int[3];
        try {
//            for (int i = 0; i <arr.length ; i++) {
//            for (int i = 1; i <=5; i++) {
            for (int i = 0; i <arr.length; i++) {
                 arr[i]=i;
                System.out.printf("数组下标：{}，的元素内容为：{}",i,arr[i]);

                System.out.println("数组下标[" + i + "]模 " + "的值:  "
//                        + arr[i] % 1);
                        + arr[i] %i);
            }
        } catch (ArrayIndexOutOfBoundsException  e) {
            System.err.println("数组下标越界异常");

        }catch (ArithmeticException e) {
            System.err.println("除数为0异常。");
        }
        System.out.println("程序正常结束");
    }
    /**
     * try－catch-finally语句
     */
    @Test
    public void  demo06(){
        int i = 0;
        String greetings[] = { " Hello world !", " Hello World !! ",
                " HELLO WORLD !!!" };
        while (i<4){
            try {
                System.out.println(greetings[i++]);
            } catch (ArrayIndexOutOfBoundsException  e) {
                System.out.println("数组下标越界异常");
            } finally {
                System.out.println("finally 执行语句。。。。。。。");
            }

        }

    }

    /**
     * 使用return 语句进行测试
     */
    @Test
    public void  demo07(){
        int i = 0;
        String greetings[] = { " Hello world !", " Hello World !! ",
                " HELLO WORLD !!!" };
        while (i<4){
            try {
                System.out.println(greetings[i++]);
//                return;  finally 执行一次
            } catch (ArrayIndexOutOfBoundsException  e) {
                System.out.println("数组下标越界异常");
//                return; 没影响
            } finally {
                System.out.println("finally 执行语句。。。。。。。");
            }

        }

    }

    /**
     *  finally 块抛异常
     */
    @Test
    public void  demo08() throws Exception {
        int i = 0;
        String greetings[] = { " Hello world !", " Hello World !! ",
                " HELLO WORLD !!!" };
        while (i<4){
            try {
                System.out.println(greetings[i++]);
//                return;  finally 执行一次
            } catch (ArrayIndexOutOfBoundsException  e) {
                System.out.println("数组下标越界异常");
//                return; 没影响
            } finally {
                throw new Exception("抛 抛.........");
            }

        }

    }

}
