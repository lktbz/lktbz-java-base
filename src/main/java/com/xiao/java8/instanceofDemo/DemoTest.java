package com.xiao.java8.instanceofDemo;

/**
 * @author lktbz
 * @version 1.0.0
 * @date 2021/9/17
 * @desc
 */
public class DemoTest {
    public static void main(String[] args) {
        int a[]={10,12,43,50,66,24,88,2,33};
        int d[]={5,3,1},i;
        f33(a,d,3,9);

        for ( i = 0; i < a.length; i++) {
            System.out.printf("%d,",a[i]);
        }
        System.out.println("\n");

    }

    private static void f33(int[] a, int[] d, int t, int n) {
        int k;
        for(k=0;k<t;k++){
            fun(a,d[k],n);
        }
    }

    private static void fun(int[] a, int dk, int n) {
        int i,j ,temp;
        for(i=dk;i<n;i++){
            if(a[i]<a[i-dk]){
                temp=a[i];
                j=i-dk;
                while (j>=0&&temp<a[j]){
                    a[j+dk]=a[j];
                    j=j-dk;

                }
                a[j+dk]=temp;

            }
        }
    }
}
