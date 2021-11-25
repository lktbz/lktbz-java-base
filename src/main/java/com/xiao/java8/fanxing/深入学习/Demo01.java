package com.xiao.java8.fanxing.深入学习;

/**
 * @Classname Demo01
 * @Description 不使用泛型时写法
 * @Date 2021/6/5
 * @Created by lktbz
 */
public class Demo01 {
    private Object[] medata;

    public Demo01(int capacity) {
        medata=new Object[capacity];
    }

    public Object getMedata(int index) {
        return medata[index];
    }
    public void add(int index,Object item){
        medata[index]=item;
    }

    public static void main(String[] args) {
        Demo01 demo01 = new Demo01(2);
        //存放数据
        demo01.add(1,"深痕");
        demo01.add(2,19);

//        取数据
        String strData = (String)demo01.getMedata(1);
        Integer intData = (Integer) demo01.getMedata(2);
//        当我们取数据的时候，发现，需要进行强制转换
    }
}
