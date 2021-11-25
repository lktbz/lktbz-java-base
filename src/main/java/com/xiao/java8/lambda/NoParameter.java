package com.xiao.java8.lambda;

/**
 * @ClassName NoParameter
 * @Description TODO
 * @Author lktbz
 * @Date 2020/12/4
 */
public class NoParameter {
    public static void main(String[] args) {
        // without lambda expression
        Sayable sayable =   new Sayable(){
            @Override
            public String say() {
                return "Return something ..";
            }
        };
        System.out.println(sayable.say());

        // with lambda expression
        Sayable sayable2 =()->{
            return "lambda Return something ..";
        };
        System.out.println(sayable2.say());
    }
    interface Sayable {
        public String say();
    }
}
