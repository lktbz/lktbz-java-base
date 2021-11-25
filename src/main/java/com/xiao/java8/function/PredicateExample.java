package com.xiao.java8.function;

import java.util.function.Predicate;

/**
 * @ClassName PredicateExample
 * @Description 函数式接口之断言的使用
 * @Author lktbz
 * @Date 2020/12/4
 */
public class PredicateExample {
    /**
     * Evaluates this predicate on the given argument.
     * 返回布尔值，比如判断类型使用
     * boolean test(T t);
     */

    public static void main(String[] args) {
//        test01();
//        test02();
        test03();

    }
    public static void test01() {
        //定义条件
        Predicate<Person> predicate = (person) -> person.getAge() > 28;
        //使用条件进行比较
        boolean zs = predicate.test(new Person("zs", 30));
        System.out.println(zs);
    }
    /**
     * 判断x>7 &&x%2==0
     */
    public static void test02() {
        Predicate<Integer> predicate = x -> x > 7;
        predicate = predicate.and(x -> x % 2 == 0);
        System.out.println(predicate.test(9));
        System.out.println(predicate.test(8));
    }
    /**
     * 条件优化
     */
    public static void test03() {
        Predicate<Integer>predicate=x->x>7&&x%2==0;
        System.out.println(predicate.test(9));
        System.out.println(predicate.test(8));
    }

}
