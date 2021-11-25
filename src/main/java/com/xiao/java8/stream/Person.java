package com.xiao.java8.stream;

/**
 * @ClassName Person
 * @Description TODO
 * @Author lktbz
 * @Date 2021/1/18
 */
public class Person {
    private String name;  // 姓名
    private int salary; // 薪资
    private String age; // 年龄
    private String sex; //性别
    private String area;  // 地区

    public Person(String name, int salary, String age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }

    public Person(String name, int salary, String age, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
