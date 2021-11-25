package com.xiao.java8.strings;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringsDemo01 {
    public static void main(String[] args) {
//        什么是字符串
        String str = "abc";
        /**
         * 字符串特点
         *
         * Strings are constant;
         * their values cannot be changed
         * String objects are immutable
         */
        char[] c = {'a', 'b', 'c'};
        String ss = new String(c);
        //上面的互相等价

        //测试是否可以修改
        String sa = "chains";
        sa.concat("end");
        System.out.printf(sa);


        // 经过测试没有修改值，。
//      现在改变引用
        sa = sa.concat("ends");
        System.out.println(sa);


//        字符串的比较
        String s1 = "xp";
        String s2 = "xp";
        String s3 = new String("xp");
        String s4 = "Saurav";
        String s5 = "XP";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s4));
        //忽略大小写比较
        System.out.println(s1.equalsIgnoreCase(s5));


        //==比较  operator compares references not values.
        System.out.println("==" + s1 == s2);
        System.out.println("==" + s1 == s3);


        //compareto 比较, unicode
        String s11 = "Sachin";
        String s22 = "Sachin";
        String s33 = "Ratan";

        System.out.println(s11.compareTo(s22));
        System.out.println(s11.compareTo(s33));
        System.out.println(s33.compareTo(s11));


        //字符串的修改
        String sap = "JSON" + "Hone";
        System.out.println(sap);

        //等价于
        String ssap = new StringBuilder().append("SJON").append("hoNE").toString();
        System.out.println("等价于" + ssap);


        //concat ,将要添加的字符串，添加到字符串末尾
        String s4e = s1.concat(s3);
        System.out.println("s1=" + s1);
        System.out.println("s3=" + s3);
        System.out.println(s4e);


        //substring  //字符串的截取


        String sunb = "exclusive";
//        截取从零开始，长度为2
        System.out.println(sunb.substring(0, 4));


        System.out.println(sunb.substring(2));

        //大小写
        System.out.println(sunb.toLowerCase());
        System.out.println(sunb.toUpperCase());

        //去除空格
        String trims = "eliminates ";
        String trims2 = "  eliminates ";
        String trims3 = " eliminates";
        String trims4 = " eliminates     dello";
        System.out.println(trims.trim());
        System.out.println(trims2.trim());
        System.out.println(trims3.trim());
        System.out.println(trims4.trim());
        System.out.println(trims4.trim().replace("  ", ""));


        //charAt  返回字符数组中的值
        System.out.println(sunb.charAt(0));
        System.out.println(sunb.charAt(5));


        //length
        System.out.println(trims.length());
        System.out.println(trims2.length());
        System.out.println(trims3.length());


        //itern
        String intern = s3.intern();
        System.out.println(intern);


        //valueof  //类型的数据转换，转换成字符串类型
        int a = 2;
        String s = String.valueOf(a);
        System.out.println(s);


        String s12 = "Java is a programming language. Java is a platform. Java is an Island.";

        System.out.println(s12.replace("Java", "Kava"));


        //字符串是否包含某个
        String name = "what do you know about me";
        System.out.println(name.contains("do you know"));
        System.out.println(name.contains("about"));
        System.out.println(name.contains("hello"));

        //大小是否包含  //false 排除大小写
        System.out.println(name.contains("About"));

        //格式化
        String str1 = String.format("%d", 101);
        String str2 = String.format("%s", "any where");
        String str3 = String.format("%f", 101f);
        String str4 = String.format("%x", 101);          // Hexadecimal value
        String str5 = String.format("%c", 'c');
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);


        String strr = new String("hello javatpoint how r u");
        char[] ch = new char[10];
        strr.getChars(6, 16, ch, 0);
        System.out.println(ch);


        //indexof
        int e = strr.indexOf("e");
        System.out.println(e);

        //join demo
        String joinString1 = String.join("-", "welcome", "to", "javatpoint");
        System.out.println(joinString1);


        StringJoiner sj = new StringJoiner(":", "[", "]");
        sj.add("George").add("Sally").add("Fred");
        String desiredString = sj.toString();
        System.out.println(desiredString);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        String commaSeparatedNumbers = numbers.stream()
                .map(i -> i.toString())
                .collect(Collectors.joining(":::"));
        System.out.println(commaSeparatedNumbers);


//       lastindexof
        String lasts = "this is index of example";
        int s6 = lasts.lastIndexOf('s');
        System.out.println(s6);
        int s7 = lasts.lastIndexOf('s', 5);
        System.out.println(s7);


        //split demo

        String sp1 = "welcome to split world";
        for (String sw : sp1.split(" ", 0)
        ) {
            System.out.println(sw);
        }

        //拼接字符串方式：
        String wechat = "Hollis";
        String introduce = "每日更新Java相关技术文章";
        String lktbz = wechat + "," + introduce;
        System.out.println(lktbz);
        String concatDemo = wechat.concat(introduce);
        System.out.println(concatDemo);

        StringBuffer wechats = new StringBuffer("Hollis");
        String introduces = "每日更新Java相关技术文章";
        StringBuffer hoils = wechats.append(",").append(introduces);
        System.out.println(hoils);

        String join = String.join(wechat, introduce);
        System.out.println("join demo" + join);
        /**
         * 字符串拼接使用总结：
         * 常用的字符串拼接方式有五种，分别是使用+、使用concat、使用StringBuilder、使用StringBuffer以及使用StringUtils.join。
         *
         * 由于字符串拼接过程中会创建新的对象，所以如果要在一个循环体中进行字符串拼接，就要考虑内存问题和效率问题。
         *
         * 因此，经过对比，我们发现，直接使用StringBuilder的方式是效率最高的。因为StringBuilder天生就是设计来定义可变字符串和字符串的变化操作的。
         *
         * 但是，还要强调的是：
         *
         * 1、如果不是在循环体中进行字符串拼接的话，直接使用+就好了。
         *
         * 2、如果在并发场景中进行字符串拼接的话，要使用StringBuffer来代替StringBuilder。
         */
//      String hasText hasLength 区别
        System.out.println("hasLength: false=" + StringUtils.hasLength(null));
        System.out.println("hasLength:false=" +  StringUtils.hasLength(""));
        System.out.println("hasLength:true=" +  StringUtils.hasLength(" ") );
        System.out.println("hasLength:true=" +  StringUtils.hasLength("Hello"));
        System.out.println("hasText:false=" + StringUtils.hasText(null) );
        System.out.println("hasText:false=" +  StringUtils.hasText("") );
        System.out.println("hasText:false=" +  StringUtils.hasText(" "));
        System.out.println("hasText:true=" +  StringUtils.hasText("12345") );
        System.out.println("hasText:true=" + StringUtils.hasText(" 12345 "));

        String demo02="abcb  ";
        System.out.println(org.apache.commons.lang3.StringUtils.trim(demo02));

        String de1 = "MyTest";
        String de2 = new StringBuilder().append("My").append("Test").toString();
        String de3 =de2.intern();
        System.out.println("de1=="+de1);
        System.out.println("de2=="+de2);
        System.out.println("de3=="+de3);
        System.out.println("s2==s1--"+s2==s1);
        System.out.println("s3==s1--"+s3==s1);
        System.out.println("s2==s3--"+s2==s3);



    }
}
