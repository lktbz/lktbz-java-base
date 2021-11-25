package com.xiao.java8.lambda;

/**
 * @ClassName MultipleStatements
 * @Description TODO
 * @Author lktbz
 * @Date 2020/12/4
 */
public class MultipleStatements {
    interface IAvarage {
        double avg(int[] array);
    }

    public static void main(String[] args) {
        // without lambda expression, IAvarage implementation using anonymous class
        IAvarage avarage = new IAvarage() {
            @Override
            public double avg(int[] array) {
                double sum = 0;
                int arraySize = array.length;

                System.out.println("arraySize : " + arraySize);
                for (int i = 0; i < array.length; i++) {
                    sum = sum + array[i];
                }
                System.out.println("sum : " + sum);

                return (sum/ arraySize);
            }
        };

        int[] array = {1,4,6,8,9};
        System.out.println(avarage.avg(array));

        IAvarage withLambda = (withLambdaArray) -> {
            double sum = 0;
            int arraySize = withLambdaArray.length;

            System.out.println("arraySize : " + arraySize);
            for (int i = 0; i < withLambdaArray.length; i++) {
                sum = sum + withLambdaArray[i];
            }
            System.out.println("sum : " + sum);

            return (sum/ arraySize);
        };

        int[] withLambdaArray = {1,4,6,8,9};
        System.out.println(withLambda.avg(withLambdaArray));
    }
}
