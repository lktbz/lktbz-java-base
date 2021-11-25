package com.xiao.java8.serializable;

import java.io.*;
import java.util.Date;

/**
 * @Classname SerializableDemo1
 * @Description 正向与反向序列化demo
 * @Date 2021/6/6
 * @Created by lktbz
 */
public class SerializableDemo1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user=new User();
        user.setName("hollis");
        user.setGender("male");
        user.setAge(23);
        user.setBirthday(new Date());
        System.out.println("新创建的对象为"+user);

//        序列化操作
        ObjectOutputStream oos=null;
        oos=new ObjectOutputStream(new FileOutputStream("tempFile"));
        //写操作
        oos.writeObject(user);

        File file=new File("tempFile");
        ObjectInputStream ois=null;
        ois=new ObjectInputStream(new FileInputStream(file));
        //反序列化
        User rUser = (User)ois.readObject();
        System.out.println("从远处获取的对象为"+rUser);
    }
}
