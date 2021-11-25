package com.xiao.java8.function;

/**
 * @ClassName MsaagePO
 * @Description 保存数据库数据
 * @Author lktbz
 * @Date 2021/1/18
 */
public class MsaagePO {
    private String name;
    private int MessageId;
    private String password;

    @Override
    public String toString() {
        return "MsaagePO{" +
                "name='" + name + '\'' +
                ", MessageId=" + MessageId +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMessageId() {
        return MessageId;
    }

    public void setMessageId(int messageId) {
        MessageId = messageId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
