package com.xiao.java8.enumapi;

public enum  EnumSingleton {
        INSTANCE;

        private Object data;

    EnumSingleton() {

    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public static  EnumSingleton getInstance(){
        return INSTANCE;
    }
    public static void main(String[] args) {
        EnumSingleton es=EnumSingleton.getInstance();
       es.setData(new Object());
        EnumSingleton es2 =EnumSingleton.getInstance();
        es2.setData(new Object());
        System.out.println(es.getData()==es2.getData());
    }
}
