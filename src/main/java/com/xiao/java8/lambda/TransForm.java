package com.xiao.java8.lambda;
@FunctionalInterface
public interface TransForm<T,R> {
    R transFrom(T t);
}
