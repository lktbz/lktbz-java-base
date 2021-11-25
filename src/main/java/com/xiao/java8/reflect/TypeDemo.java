package com.xiao.java8.reflect;

import java.lang.reflect.Type;

/**
 * @ClassName TypeDemo
 * @Description TODO
 * @Author lktbz
 * @Date 2021/1/19
 */
public class TypeDemo {
    public static void main(String[] args) {
        Type type=new TypeD("zs");
        System.out.println(type.getTypeName());

    }
    static class TypeD implements Type{
        private String name;

        public TypeD(String name) {
            this.name = name;
        }
        @Override
        public String getTypeName() {
            return name;
        }
    }
}
