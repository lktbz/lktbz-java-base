package com.xiao.java8.maths;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Description 金额的精确计算
 * @Author lktbz
 * @Date 2021/06/22
 */
public class BigDecimalDemo {
    /**
     * 加
     */
    @Test
    public void add() {
        BigDecimal decimal = BigDecimal.ZERO;
        decimal = decimal.add(new BigDecimal("10.210"));
        System.out.println(decimal);
    }
    /**
     * 减
     */
    @Test
    public void subStruct() {
        BigDecimal decimal = new BigDecimal("2.124");
        decimal = decimal.subtract(new BigDecimal("0.108"));
        System.out.println(decimal);
    }
    /**
     * 乘
     */
    @Test
    public void multiply() {
        BigDecimal decimal = new BigDecimal("2.124");
        decimal = decimal.multiply(new BigDecimal("4.108"));
        System.out.println(decimal);
    }
    /**
     * 除
     */
    @Test
    public void divide() {
        BigDecimal decimal = new BigDecimal("2.224");
        decimal = decimal.divide(new BigDecimal("1.112"));
        System.out.println(decimal);
    }


}
