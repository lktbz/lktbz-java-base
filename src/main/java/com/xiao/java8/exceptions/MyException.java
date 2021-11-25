package com.xiao.java8.exceptions;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/11
 */
public class MyException  extends RuntimeException{
    private String message;
    private int code;
    public MyException(String message,int code) {
        this.message=message;
        this.code=code;

    }
    public MyException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
