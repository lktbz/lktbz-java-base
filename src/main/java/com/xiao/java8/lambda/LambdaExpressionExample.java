package com.xiao.java8.lambda;

/**
 * @ClassName LambdaExpressionExample
 * @Description TODO
 * @Author lktbz
 * @Date 2020/12/4
 */
public class LambdaExpressionExample {

    /**
     * Why use Lambda Expression
     * To provide the implementation of the Java 8 Functional Interface.
     * Less coding.
     * Lambda Expressions enable you to encapsulate a
     * single unit of behavior and pass it to other code.
     * You can use lambda expressions if you want a certain action performed
     * on each element of a collection, when a process is completed, or when a process encounters an error.
     */
    public static void main(String[] args) {
        int width=10;
        Drawable withLambda=()->{
            System.out.println("Drawing "+width);
        };
        withLambda.draw();
    }

        interface Drawable{
        public void draw();
    }
}
