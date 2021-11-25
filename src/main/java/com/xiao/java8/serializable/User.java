package com.xiao.java8.serializable;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname User
 * @Description TODO
 * @Date 2021/6/6
 * @Created by lktbz
 */
public class User implements Serializable {
    private static final long serialVersionUID = 6608825979654805825L;
    private String name;
    private int age;
    private Date birthday;
    private transient String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                '}';
    }
}
