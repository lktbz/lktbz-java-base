package com.xiao.java8.fanxing;

public class Generic<T> {
    /**
     * T 类型的name
     */
  private  T name;

    @Override
    public String toString() {
        return "Generic{" +
                "name=" + name +
                '}';
    }

    public Generic(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }
}
