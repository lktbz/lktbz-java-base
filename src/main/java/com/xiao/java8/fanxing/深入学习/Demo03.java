package com.xiao.java8.fanxing.深入学习;

import com.xiao.java8.fanxing.GenericInterfacce;

/**
 * @Classname Demo03
 * @Description 实现泛型接口
 * @Date 2021/6/5
 * @Created by lktbz
 */
public class Demo03 {
    /**
     * 没有指明参数类型
     */
 public class GenerInterface01 implements GenericInterfacce{
     @Override
     public Object send() {
         //返回object
         return null;
     }
 }
    public class GenerInterface02 implements GenericInterfacce<String>{

        @Override
        public String send() {
            //返回string
            return null;
        }
    }
}
