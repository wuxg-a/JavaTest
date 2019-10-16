package com.wxg.base.type;

/**
 * Created by wuxg-a on 2019/10/16.
 */

//https://blog.csdn.net/qq_26947195/article/details/79505553
public class IntergeTest {

    public static void main(String[] args) {
        test2();
    }

    private static  void test1() {
        Integer Integer1 = 200;
        Integer Integer2 = 200;
        System.out.println("=" + (Integer1 == Integer2));

        //-127-128会缓存，所以相等
        Integer Integer3 = 100;
        Integer Integer4 = 100;
        int inttest = 100;
        System.out.println("=" + (Integer3 == Integer4));
        System.out.println(inttest == Integer3);

        Integer Integer5 = new Integer(100);
        Integer Integer6 = new Integer(100);
        System.out.println("=" + (Integer5 == Integer6));
    }

    private static void test2() {
        Integer i1=10;
        Integer i2=10;
        Integer i3=20;
        Integer i11=new Integer(10);
        Integer i22=new Integer(10);
        Integer i33=new Integer(20);
        System.out.println(i1==i2);
        System.out.println(i1==i11);
        System.out.println(i11==i22);
        System.out.println(i3==(i1+i2));
        System.out.println(i3==(i11+i22));
        System.out.println(i33==(i1+i2));
        System.out.println(i33==(i11+i22));
    }
}
