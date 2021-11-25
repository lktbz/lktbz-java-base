package com.xiao.java8.strings;

import org.junit.Test;

/**
 * @Classname StringBufferDemo
 * @Description 可修改的字符串
 * @Date 2021/5/13 10:16
 * @Created by lktbz
 */
public class StringBufferDemo {
    /**
     * 添加demo
     */
    @Test
    public void test01(){
        StringBuffer sb=new StringBuffer("hello");
        sb.append(" World");
        System.out.println(sb);
    }

    @Test
    public void test02(){
        StringBuffer sb=new StringBuffer("hello");
        sb.insert(2,"World");
        System.out.println(sb);
    }
    /**
     * 从结果可以看出，insert 插入位置不确定，而append 插入的顺序固定位最后
     */

     //替换
    @Test
    public void test03(){
        StringBuffer sb=new StringBuffer("hello");
        sb.replace(0,2,"lktbz");
        System.out.println(sb);
    }
    //删除操作
    @Test
    public void test04(){
        StringBuffer sb=new StringBuffer("hello");
        sb.delete(0,1);
        System.out.println(sb);
    }
    //翻转
    @Test
    public void test05(){
        StringBuffer sb=new StringBuffer("hello");
        sb.reverse();
        System.out.println(sb);
    }

    //容量
    @Test
    public void test06(){
        StringBuffer sb=new StringBuffer();
        //默认16
        System.out.println(sb.capacity());

        sb.append("java is my favourite language");
        System.out.println(sb.capacity());
    }

}
