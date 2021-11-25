package com.xiao.java8.collections;

import java.util.*;
/**
 * @Classname CollectionIsEmptyDemo
 * @Description 集合的非空判断
 * @Date 2021/6/7
 * @Created by lktbz
 */
public class CollectionIsEmptyDemo {
    public static void main(String[] args) {
        List al=new ArrayList();
        if(al.isEmpty()){
            System.out.println("集合元素是空的");
        }
        Map<String,String>msp=new HashMap<>();
        msp.put("zs","zssd");
        msp.put("zs1","jkll");
        msp.put("zs2","zxxccvb");
        if(!msp.isEmpty()){
            System.out.println("map 集合不为空。。。");
        }
        Collection<String> values = msp.values();
        System.out.println(values);
    }
}
