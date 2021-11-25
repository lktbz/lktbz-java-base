package com.xiao.java8.io.basic.io;

import java.io.*;

/**
 * @Classname ObjectStreamDemo02
 * @Description objectStreamInput demo
 * @Date 2021/6/6
 * @Created by lktbz
 */
public class ObjectStreamDemo02 {
    /**
     * 写入的目的地
     */
    private static final String TMP_FILE = "box.tmp";
    public static void main(String[] args) throws IOException {
//        testWrite();
        testRead();
    }

    /**
     * 写操作， 常用于对象的序列化操作
     * @throws IOException
     */
    private static void testWrite() throws IOException {
        ObjectOutputStream outputStream=null;
        try {
             outputStream=new ObjectOutputStream(new FileOutputStream(TMP_FILE));
            // 写入自定义的Box对象，Box实现了Serializable接口
            Box box = new Box("desk", 80, 48);
            outputStream.writeObject(box);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void testRead() throws IOException {
        ObjectInputStream inputStream=null;
        try {
            inputStream=new ObjectInputStream(new FileInputStream(TMP_FILE));

           Box box = (Box)inputStream.readObject();
            System.out.println("box: " + box);

            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();

    }

}}
    class Box implements Serializable {
        private int width;
        private int height;
        private String name;

        public Box(String name, int width, int height) {
            this.name = name;
            this.width = width;
            this.height = height;
        }

        @Override
        public String toString() {
            return "["+name+": ("+width+", "+height+") ]";
        }
    }