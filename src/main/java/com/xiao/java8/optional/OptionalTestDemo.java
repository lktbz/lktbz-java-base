package com.xiao.java8.optional;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Description Optional 空指针解决办法
 * @Author lktbz
 * @Date 2021/07/04
 */
public class OptionalTestDemo {
    /**
     * 测试下hello world of
     */
    @Test
    public void test01(){
        Optional<String> hello = Optional.of("hello");
        if(hello.isPresent()){
            String s = hello.get();
            System.out.println(s);
        }else {
            System.out.println("optional is not value");
        }

    }

    /**
     *   empty null
     */
    @Test
    public void test02(){
        Optional<Object> empty = Optional.empty();
        if(empty.isPresent()){
            System.out.println("非空对象");
        }else {
            System.out.println("传递了一个空对象");
        }
    }

    /**
     * ofNullable & get 这是对上面的进行综合考虑，不存在则给个默认的，存在就传给它
     */
    @Test
    public void test03(){
        Optional<Object> o = Optional.ofNullable(null);
        if(!o.isPresent()){
            System.out.println("传过来的是个空对象");
        }
        Optional<String> lktbz = Optional.ofNullable("lktbz");
        if(lktbz.isPresent()){
            System.out.println("获取的对象为"+lktbz.get());
        }
    }

    /**
     * isPresent & ofNullable
     */
    @Test
    public void test04(){
// Creating optional
        Optional<String> optional = Optional.ofNullable("javaprogramto.com");

        System.out.println("Chceking if optional has value with isPresent() method");
        System.out.println("isPresent value : "+optional.isPresent());

        // empty optional
        Optional<String> emptyOptional = Optional.ofNullable(null);
        System.out.println("isPresent value for empty optional : "+emptyOptional.isPresent());
    }

    /**
     *  ofNullable 列表对象的处理
     */
    @Test
    public void test05(){
        List<Integer> list = Arrays.asList(1, 2, 0, 4, 5);
        Optional<List<Integer>> list2 = Optional.ofNullable(list);
//        如果存在值，就进行下一步的操作
        list2.ifPresent(ops->ops.forEach(System.out::println));

    }

    /**
     * orElse 兜底策略，null 值时，给兜底策略
     */
    @Test
    public void test06(){
        Optional<String> o1 =  Optional.ofNullable(null);
        String one = o1.orElse("one");
        System.out.println(one);
        Optional<String> o11 =  Optional.ofNullable("lktbz");
        String one1 = o11.orElse("one");
        System.out.println(one1);
    }

    /**
     * orElseGet 存在使用默认的，不存在则自定义相应的值，可变性较高
     */
    @Test
    public void test07(){
        Optional<String> o1 = Optional.ofNullable(null);
//        传入null并且自定义其内容
        String value = o1.orElseGet(() -> "Default One  from  supplier");
        System.out.println("Fetching the value from orElseGet() : " + value);
        Optional<Integer> intOptional = Optional.of(134);
//        传入实际的值，自定义默认的值
        int defaultValue = intOptional.orElseGet(() -> 15);
        System.out.println("orElseGet Int  default value :" + defaultValue);
    }

    /**
     *    orElseThrow
     */
    @Test
    public void test08(){
        Optional<Integer> o1 = Optional.ofNullable(134);
//        传入null并且自定义其内容
        Integer value = o1.orElseThrow();
        System.out.println("Fetching the value from orElseThrow() : " + value);
        Optional<String> intOptional = Optional.of(null);
//        传入实际的值，自定义默认的值
        String integer = intOptional.orElseThrow();
        System.out.println("Fetching the value from orElseThrow() : " + integer);
    }

    /**
     * 提高
     */
    @Test
    public void test09() throws Exception {

//        Optional<String> optional = Optional.of("Hello World");
//        Optional<String> optional = Optional.of(null);
          Optional<String> optional = Optional.empty();
//        Optional<String> optional = Optional.of("");

        String msg = optional.orElseThrow(()->new Exception("Message not available"));

        System.out.println(msg);

    }
}
