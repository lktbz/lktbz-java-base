package com.xiao.java8.instanceofDemo;

/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/9/15
 * @desc
 */
public class Pers extends PubPers{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pers{" +
                "name='" + name + '\'' +
                '}';
    }
    @Override
    void sayHello(String name) {
        System.out.println("子类负责实现的方法。。。。");
    }
}
