package com.xiao.java8.object.utils;

/**
 * @author lktbz
 * @description: TODO
 * @date 2021/11/22
 */
public class NullVo {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NullVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
