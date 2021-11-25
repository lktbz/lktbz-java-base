package com.xiao.java8.object.utils;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

import java.util.Objects;
import java.util.Optional;

/**
 * @author lktbz
 * @description: java 对象非空处理方式
 * @date 2021/11/22
 */
public class ObjectUtilsDemo {
    /**
     *   普通判断对象是否为空
     *
     *   apache common lang3
      */
   @Test
   public void test01(){
   //定义
    NullVo nv=new NullVo();
//       boolean notEmpty = ObjectUtils.isNotEmpty(nv);
       nv.setId(1);

       boolean notEmpty = ObjectUtils.isEmpty(nv);
       System.out.println(notEmpty);
   }

    /**
     * spring framework
     */
    @Test
    public void test02(){
        //定义
//        NullVo nv=new NullVo();
        NullVo nv=null;
        boolean empty = org.springframework.util.ObjectUtils.isEmpty(nv);
        System.out.println("结果："+empty);

    }

    /**
     * jdk
     */
    @Test
    public void test03(){
        //定义
        NullVo nv=null;
//        NullVo nv=new NullVo();  //对象null 值的赋予
        boolean empty = Objects.isNull(nv);
        boolean noEmpty = Objects.nonNull(nv);
        System.out.println(empty);
        System.out.println(noEmpty);
        Objects.requireNonNull(nv,"不存在相应的信息");
    }

    /**
     * java8 optional
     */
    @Test
    public void test04(){
         NullVo nullVo=new NullVo();
//        NullVo nullVo=null;
        Optional<NullVo> nullVo1 = Optional.of(nullVo);
        if (nullVo1.isPresent()&&nullVo1.isEmpty()){
            System.out.println("存在值会展示其信息："+nullVo1.get());
        }else {
            System.out.println("不存在输出");
        }


    }

}
