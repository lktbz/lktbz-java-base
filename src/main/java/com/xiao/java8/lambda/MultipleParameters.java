package com.xiao.java8.lambda;

/**
 * @ClassName MultipleParameters
 * @Description TODO
 * @Author lktbz
 * @Date 2020/12/4
 */
public class MultipleParameters {
    interface Addable{
        int add(int a,int b);
    }
    public static void main(String[] args) {
        // without lambda expression
        Addable addable = new Addable() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };
        addable.add(10, 20);

        Addable addable2 =  (a,b)->(a+b);
        System.out.println(addable2.add(10,20));


        Addable addable3 =  (int aa,int bb)->(aa+bb);
        System.out.println(addable3.add(110,20));
    }
}
