package com.xiao.java8.JUC.locked;

/**
 * @Classname ThreadLocalDemo04
 * @Description threadlocal 隔离数据，常见应用场景： 连接池连接数的隔离，日期格式化的隔离
 * @Date 2021/6/1
 * @Created by lktbz
 */
public class ThreadLocalDemo04 {

    public static void main(String[] args) {
        /**
         * 使用方式一： set /get
          */
     ThreadLocal<Integer> inLocal=new ThreadLocal<>();
     inLocal.set(2);

     System.out.println(inLocal.get());

        /**
         * 使用方式二：
         */
        ThreadLocal<Integer> integerThreadLocal = ThreadLocal.withInitial(() -> 1);
        ThreadLocal<String[]> threadLocal = ThreadLocal.withInitial(() -> new String[]{"a", "v", "d"});
        for (String s : threadLocal.get()) {
            System.out.println("使用方式二:-"+s);
        }
        ;
    }
}
