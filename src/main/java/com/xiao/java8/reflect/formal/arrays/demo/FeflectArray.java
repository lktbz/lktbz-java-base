package com.xiao.java8.reflect.formal.arrays.demo;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * @Description 反射创建数组
 * @Author lktbz
 * @Date 2021/06/25
 */
public class FeflectArray {
    /**
     * 这个是我们创建的最终目标数组
     */
    private static String R = "java.math.BigInteger[] bi = {123,234,345}";
    private static final String[] S = new String[]{"123", "234", "345"};

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<BigInteger> bigIntegerClass = BigInteger.class;
        Object o = Array.newInstance(bigIntegerClass, 3);
        for (int i = 0; i <S.length ; i++) {
            String each= S[i];
            Constructor<BigInteger> constructor = bigIntegerClass.getConstructor(String.class);
            BigInteger bigInteger = constructor.newInstance(each);
            Array.set(o,i,bigInteger);
        }
        Object[] result = (Object[]) o ;
        System.out.println(String.format("%s[] = %s", bigIntegerClass, Arrays.toString(result)));

    }
}
