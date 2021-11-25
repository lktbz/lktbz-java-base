package com.xiao.java8.aysn.callback.task;

/**
 * @ClassName UTO
 * @Description TODO
 * @Author lktbz
 * @Date 2021/1/25
 */
public class UTO {
    private String msg;

    @Override
    public String toString() {
        return "UTO{" +
                "msg='" + msg + '\'' +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public UTO setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
