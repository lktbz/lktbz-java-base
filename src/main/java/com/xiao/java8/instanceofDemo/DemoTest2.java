package com.xiao.java8.instanceofDemo;

/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/9/17
 * @desc
 */
public class DemoTest2 {
    public static void main(String[] args) {
        int a[]={25,4,256,9,-38,47,128,-256,64};
        int k,m=0,temp;
        while (a[m]<0&&m<9){
            m=m+1;
        }
        k=m;
        while (k<9){
            while (a[k]>= 0 && k<9){
                k=k+1;
            }
            if(k<9){
                temp=a[k];
                a[k]=a[m];
                a[m]=temp;
                m=m+1;
            }
        }
        System.out.println(a);

    }



}
