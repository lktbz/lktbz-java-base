package com.xiao.java8.fanxing.深入学习;

/**
 * @Classname Demo05
 * @Description 通配符的使用
 * @Date 2021/6/5
 * @Created by lktbz
 */

import java.util.List;

/**
 * <?> 无限制通配符
 * <? extends E> extends 关键字声明了类型的上界，表示参数化的类型可能是所指定的类型，或者是此类型的子类
 * <? super E> super 关键字声明了类型的下界，表示参数化的类型可能是指定的类型，或者是此类型的父类
 */
public class Demo05 {

    class ChildBookBean{

    }
    class BookBean{

    }

    /**
     * < K,E> 需要在方法进行定义
     *  E 为返回型类型
     *  参数中的为 为指定的参数类型
     * @param a1
     * @param a2
     * @param <K>
     * @param <E>
     * @return
     */
    public < K,E> E test2(K a1, E a2){
        E resut=null;
        return resut;
    }

    /**
     * 进行变种操作
     */
    /**
     * 分别加上限定符 ChildBookBean  BookBean
     * @param a1
     * @param a2
     * @param <K>
     * @param <E>
     * @return
     */
    public < K extends ChildBookBean,E extends BookBean> E test3(K a1, E a2){
        E resut=null;
        return resut;
    }
    /**
     * 下界通配符
     * 生产者有上限、消费者有下限：
     */
    public <E> void add(List<? super E> dst, List<E> src){
        for (E e : src) {
            dst.add(e);
        }
    }
}
