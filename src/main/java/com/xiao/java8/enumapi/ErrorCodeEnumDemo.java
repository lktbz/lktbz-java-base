package com.xiao.java8.enumapi;

/**
 *     业务代码中的：错误码使用
 */

public class ErrorCodeEnumDemo {
    enum ErrorCodeEn {
        OK(0, "成功"),
        ERROR_A(100, "错误A"),
        ERROR_B(200, "错误B");

        ErrorCodeEn(int number, String msg) {
            this.code = number;
            this.msg = msg;
        }

        private int code;
        private String msg;

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }

        @Override
        public String toString() {
            return "ErrorCodeEn{" + "code=" + code + ", msg='" + msg + '\'' + '}';
        }

        public static String toStringAll() {
            StringBuilder sb = new StringBuilder();
            sb.append("ErrorCodeEn All Elements: [");
            for (ErrorCodeEn code : ErrorCodeEn.values()) {
                sb.append(code.getCode()).append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(ErrorCodeEn.toStringAll());
        for (ErrorCodeEn s : ErrorCodeEn.values()) {
            System.out.println(s);
        }
    }
}
