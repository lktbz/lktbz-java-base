package com.xiao.java8.JUC.locked;

import java.util.HashMap;

/**
 * @ClassName ThreadLocalDemo
 * @Description TODO
 * @Author lktbz
 * @Date 2021/1/21
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<String> local=new ThreadLocal();
        //常用写法
        local.set("haha");
        System.out.println(local.get());
//        dubbo中初始化用法
        ThreadLocal<Integer[]> threadLocal = ThreadLocal.withInitial(() -> new Integer[]{1, 2, 3, 4});
        for (Integer integer : threadLocal.get()) {
            System.out.println(integer);
        }
//        创建方式三
        ThreadLocal<HashMap<Object, Object>> hashMapThreadLocal = ThreadLocal.withInitial(HashMap::new);

        /**
         * 从doc 上说，为每个线程独有的一个空间
         */




    }

}
