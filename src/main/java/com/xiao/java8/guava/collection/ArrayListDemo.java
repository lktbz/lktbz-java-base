package com.xiao.java8.guava.collection;

import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<Integer> ins= Lists.newArrayList();
        ins.add(15);
        ins.add(30);
        ins.add(10);
        ins.add(5);
        //foreach
        for (Integer is:ins
             ) {
            System.out.println(is);
        }
        //get
        for(int i=0;i<ins.size();i++){
            System.out.println(ins.get(i));
        }
    }

    /**
     * 数组的嵌套
     */
    @Test
    public void test01(){
      List<String >list=Lists.newArrayList();
      list.add("a");
      list.add("b");
      list.add("c");
      list.add("d");
        List<String >list2=Lists.newArrayList();
        list2.add("person");
        list2.add("child");
        list2.add("class");
        list2.add("room");
      List<List<String>>al=new ArrayList<>();
      al.add(list);
      al.add(list2);
        System.out.println(al);
    }

    /**
     *  字符传变成字符列表
     */
    @Test
    public void test02(){
        List<Character> jhon = Lists.charactersOf("jhon");
        System.out.println(jhon);
    }

    /**
     * 划分
     */
    @Test
    public void test03(){
        List<String> names = Lists.newArrayList("John","Jane","Adam","Tom","Viki","Tyler");
        List<List<String>> partition = Lists.partition(names, 2);
        System.out.println(partition);
    }

    /**
     * 列表去重
     */
    @Test
    public void test04(){
        List<Character> chars = Lists.newArrayList('h','e','l','l','o');
        ImmutableList<Character> characters = ImmutableSet.copyOf(chars).asList();
        System.out.println(characters);
    }

    /**
     * 列表去空
     */
    @Test
    public void test05(){
        List<String> names = Lists.newArrayList("John", null, "Adam", null, "Jane");
        Iterables.removeIf(names, Predicates.isNull());
        System.out.println(names);

    }

    @Test
    public void test06(){
        //写入时copoy的数组，适合读取时
        CopyOnWriteArrayList<String> arrayList=new CopyOnWriteArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        System.out.println(arrayList);

        arrayList.add(1,"two");
        System.out.println(arrayList);

    }

    /**
     *  arrays 工具类
     */
    @Test
    public void test07(){
        List<String> list = Arrays.asList("t", "v", "s", "sd");


    }

    /**
     * collections
     */
    @Test
    public void test08(){
        ArrayList<Integer> objects = Lists.newArrayList();
        Map emptyMap = Collections.EMPTY_MAP;

        for(int i=0;i< 100000;i++){
            objects.add(i);
        }
        int i = Collections.binarySearch(objects, 99951);
        System.out.println(i);

    }
    @Test
    public void test09(){
     List al=new ArrayList();
     al.add("a");
     al.add("b");
     al.add("c");
     al.add("d");
     al.add(1);
        List list = Collections.checkedList(al, String.class);
        System.out.println(list);
        list.add(10);//报错。经过checkliT 的集合在插入不容类型的就会报错
        System.out.println(list);

    }
    @Test
    public void test10(){
        Map<Object, Object> objectObjectMap = Collections.emptyMap();
        objectObjectMap.put("1","2");//不支持的操作
        System.out.println(objectObjectMap);
    }

    @Test
    public void test11(){
        Set<String> singleton = Collections.singleton("1");
        singleton.add("one");//不支持的操作
        for (Object o : singleton.toArray()) {
            System.out.println(o);
        }
        ;
    }

    /**
     *  加锁方式
     */
    @Test
    public void test12(){
        List<String> list = Collections.synchronizedList(Arrays.asList("a", "v", "c", "d", "d", "f"));
        System.out.println(list);

    }
    @Test
    public void test13(){
        String s="hello";
        System.out.println(s.length());
        int o = s.indexOf("o");
        System.out.println(o);

    }
    /**
     * Map<String,List<>> 嵌套实际业务映射
     *  手机品牌很多，其中又有很多型号
     *   eg: iphone品牌，型号有12,12pro 12 pro max 11
     *       xiaomi 品牌，型号有 12 11note等，现在就用相应的数据结构表示
     */
    @Test
    public void test020(){
      Map<String ,List<String>>brand= new HashMap<>();
      List<String>iphoneModel=Lists.newArrayList();
      List<String>xiaomiModel=Lists.newArrayList();
      List<String>huaweiModel=Lists.newArrayList();
      List<String>vivoModel=Lists.newArrayList();
      iphoneModel.add("iphone 12");
      iphoneModel.add("iphone 12 pro");
      iphoneModel.add("iphone 12 pro max");
      iphoneModel.add("iphone 11");
      xiaomiModel.add("12");
      xiaomiModel.add("12 lite");
      xiaomiModel.add("12 pro");
      xiaomiModel.add("11 note");
      huaweiModel.add("p40");
      huaweiModel.add("p40+");
      huaweiModel.add("mate 30");
      huaweiModel.add("mate 30 pro");
      vivoModel.add("x20");
      vivoModel.add("x20 pro");
        brand.put("iphone",iphoneModel);
        brand.put("xiaomi",xiaomiModel);
        brand.put("huawei",huaweiModel);
        brand.put("vivo",vivoModel);
        System.out.println(brand);
    }


}
