package com.xiao.java8.instanceofDemo;

import org.junit.Test;

/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/9/15
 * @desc 测试下instanceof 使用
 */
public class Demo {
    /**
     * 测试空对象看看
     */
    @Test
    public void test01() {
        Pers pers = new Pers();
        System.out.println(null instanceof Pers);
        System.out.println(null instanceof Object);
        System.out.println(pers instanceof Object);
        System.out.println(pers instanceof Pers);
        /**
         * 从打印结果来看 对对象类型进行了判断
         */
    }
    @Test
    public void test02() {
        Pers pers=new Pers();
        pers.setName("zs");
        //测试子父类

        System.out.println(pers instanceof PubPers);
        System.out.println(pers.getName());
//        System.out.println(PubPers instanceof pers);  报错
        Pers ps=new Pers();

        System.out.println(ps instanceof PubPers);
    }
}


