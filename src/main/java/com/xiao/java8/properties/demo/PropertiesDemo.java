package com.xiao.java8.properties.demo;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * @Description properties
 * @Author lktbz
 * @Date 2021/06/30
 */
public class PropertiesDemo {
    /**
     * 创建并设置本地数据读取数据
     */
    @Test
    public void test01(){
        Properties properties=new Properties();
         properties.setProperty("name","lktbz");
        String name = properties.getProperty("name");
        System.out.println(name);
    }

    /**
     * 遍历
     */
    @Test
    public void test02(){
        Properties properties=new Properties();
        properties.setProperty("key1", "value1");
        properties.setProperty("key2", "value2");
        properties.setProperty("key3", "value3");
        properties.forEach((s,v)->{
            String o =(String) properties.get(s);
            System.out.println(o);
        });
    }
    /**
     * 存储
     */
    @Test
    public void test03(){
        Properties properties = new Properties();

        properties.setProperty("property1", "value1");
        properties.setProperty("property2", "value2");
        properties.setProperty("property3", "value3");

        try {
            FileWriter writer=new FileWriter("db.properties");
            properties.store(writer,"test");
            System.out.println("end");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  写入中文
     */
    @Test
    public void test04(){
        Properties properties = new Properties();

        properties.setProperty("name", "小马哥");
        properties.setProperty("worker", "赌神");
        properties.setProperty("address", "香港");

        try {
            FileWriter writer=new FileWriter("name.properties", true);
            properties.store(writer,"test");
            System.out.println("end");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过文件加载数据
     */
    @Test
    public void test05(){
        Properties properties=new Properties();
        try {
            FileReader reader=new FileReader("name.properties");
            properties.load(reader);
            System.out.println(properties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  文件写入到xml
     */
    @Test
    public void test06() throws IOException {
        Properties properties=new Properties();
        properties.setProperty("name", "小马哥");
        properties.setProperty("worker", "赌神");
        properties.setProperty("address", "香港");

        FileOutputStream outputStream=new FileOutputStream("name.xml");
        properties.storeToXML(outputStream,"测试写入xml", Charset.forName("UTF-8").toString());
    }

    /**
     * 从xml 读取文件
     * @throws IOException
     */
    @Test
    public void test07() throws IOException {
        Properties properties = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream("name.xml")){
            properties.loadFromXML(fileInputStream);
            System.out.println(properties.toString());
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     *    通过类加载
     */
    @Test
    public void test08() throws IOException {
        Class<PropertiesDemo> propertiesDemoClass = PropertiesDemo.class;
        InputStream resourceAsStream = propertiesDemoClass.getResourceAsStream("name.properties");
        Properties properties=new Properties();
        properties.load(resourceAsStream);
        System.out.println(properties);
    }

    /**
     * 系统配置文件 properties
     * @throws IOException
     */
    @Test
    public void test09() throws IOException {
        Properties properties = System.getProperties();
        System.out.println(properties);
    }
    @Test
    public void test10() throws IOException {
        Properties properties = System.getProperties();
        String user = properties.getProperty("user.name");
        System.out.println(user);
    }

}