package com.xiao.java8.lambda;

/**
 * @ClassName SingleParameter
 * @Description TODO
 * @Author lktbz
 * @Date 2020/12/4
 */
public class SingleParameter {
    interface Printable {
        void print(String msg);
    }
    public static void main(String[] args) {
        // without lambda expression
        Printable printable   =new Printable(){
            @Override
            public void print(String msg) {
                System.out.println(msg);
            }
        };
        printable.print(" Print message to console....");
        // with lambda expression
        Printable printable2   = (mg)-> System.out.println(mg);
        printable2.print("   lambda Print message to console....");
    }
}
