package com.xiao.java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName AllStreamDemo
 * @Description map 与f
 * @Author lktbz
 * @Date 2021/1/18
 */
public class AllStreamDemo {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, "18", "male", "New York"));
        personList.add(new Person("Jack", 7000, "26", "male", "Washington"));
        personList.add(new Person("Lily", 7800, "30", "female", "Washington"));
        personList.add(new Person("Anni", 8200, "16", "female", "New York"));
        personList.add(new Person("Owen", 9500, "40", "male", "New York"));
        personList.add(new Person("Alisa", 7900, "58", "female", "New York"));
//        test01(personList);
//        test03();
//        test04();
//          test05();
//        test06();
        test07();
    }

    public static void test01(List<Person> personList) {
        /**
         * 筛选员工中工资高于8000的人，并形成新的集合。
         */
        List<String> collect = personList.stream().
                filter((person -> person.getSalary() > 8000))
                .map(Person::getName).collect(Collectors.toList());
        System.out.print("高于8000的员工姓名：" + collect);

    }

    //    mapdemo
    public static void test02() {
        //将一个列表，转换成int 类型
        List<String> listOfStrings = Arrays.asList("1", "2", "3", "4", "5");
        List<Integer> collect = listOfStrings.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    //flatMap
    public static void test03() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(7, 8, 9);
        List<List<Integer>> lists = Arrays.asList(list1, list2, list3);
        System.out.println(lists);
//        将三个类型的列表转换成一个列表
//        List<Integer> collect = lists.stream().flatMap(x -> x.stream())
//                .collect(Collectors.toList());
//        System.out.println("转换后的值为："+collect);
//        转换成String 类型
        List<String> collect = lists.stream().
                flatMap(x -> x.stream().
                        map(String::valueOf))
                .collect(Collectors.toList());
        System.out.println("collect" + collect);
    }

    public static void test04() {
        Integer integer = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(":=" + integer);
        Integer minNumber = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .min(Comparator.comparing(Integer::valueOf))
                .get();
        System.out.println(":=" + minNumber);

    }

    /**
     * 对象之间的比较
     */
    public static void test05() {
        List<Employee> employees = new ArrayList<Employee>();

        employees.add(new Employee(1, "Lokesh", 36));
        employees.add(new Employee(2, "Alex", 46));
        employees.add(new Employee(3, "Brian", 52));
//        比较年纪最大的姓名：
        Comparator<Employee> employeeComparator = Comparator.comparing(employee -> employee.getAge());
        Employee employee = employees.stream().max(employeeComparator).get();
        System.out.println("年纪最大的 是" + employee);
        Employee employee1 = employees.stream().min(employeeComparator).get();
        System.out.println("年纪最小的是" + employee1);
    }

    public static void test06() {
//        随机数
        Random random = new Random();
        random.ints(3).sorted().forEach(System.out::println);
    }

    public static void test07() {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .stream();
//        Integer integer = stream.reduce((f, s) -> f).orElse(-1);
//        System.out.println(integer);
        /**
         * f 为第一个数
         * s 为生成的最后一个数字
         */
        Integer integer2= stream.reduce((f, s) -> s).orElse(-1);
        System.out.println(integer2);

    }


    static class Employee {
        private int id;
        private String name;
        private int age;

        public Employee(int id, String name, int age) {
            super();
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

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

        @Override
        public String toString() {
            StringBuilder str = null;
            str = new StringBuilder();
            str.append("Id:- " + getId() + " Name:- " + getName() + " Age:- " + getAge());
            return str.toString();
        }
    }
}
