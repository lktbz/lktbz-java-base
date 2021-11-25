package com.xiao.java8.fanxing.深入学习;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname Demo04
 * @Description 泛型方法使用
 * @Date 2021/6/5
 * @Created by lktbz
 */
public class Demo04 {
    /**
     * 泛型方法之：
     * 传统写法
     * @param s1
     * @param s2
     * @return
     */
    public Set union(Set s1,Set s2){
        Set result=new HashSet(s1);
        result.addAll(s2);
        return result;

    }

    /**
     *   set<E>前使用 <E> 理解：参数级别使用是否需要声明呢？
     *   或者说按照某种特定规则存在呢？
     *   抽象思维的重要性
     * @param s1
     * @param s2
     * @param <E>
     * @return
     */
    public <E> Set<E> union2(Set<E> s1, Set<E> s2){
        Set<E>se=new HashSet<>(s1);
        se.addAll(s2);
        return se;
    }
}
