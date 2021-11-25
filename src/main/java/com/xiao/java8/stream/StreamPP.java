package com.xiao.java8.stream;

import java.util.HashMap;
import java.util.Map;

public class StreamPP {
    public static void main(String[] args) {
//        List<User> userList = Arrays.asList(
//                new User(1,"aaa",20),
//                new User(2,"bbb",30),
//                new User(3,"ccc",40));
//
//        Map<Integer, User> map =userList.stream().collect(Collectors.toMap(User::getId,user -> user));
//        map.forEach((k,v)->{
//            System.out.println("key: " + k + "    value: " + v);
//        });


        Map<String ,String>testMap=new HashMap<>();
        testMap.put("1","aaa");
        testMap.put("2","bbb");
        System.out.println(testMap.get(1));
        System.out.println(testMap.get("1"));
    }
}
