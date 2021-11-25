package com.xiao.java8.guava.collection;

import java.util.Date;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/04
 */
public class Item {
    private Date date;
    private String name;
    private Double score;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Item{" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
