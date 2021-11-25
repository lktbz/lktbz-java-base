package com.xiao.java8.lambda;

@FunctionalInterface
public interface Generator<T, R> {
    R create(T t);
}