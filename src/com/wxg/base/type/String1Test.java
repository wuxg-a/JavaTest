package com.wxg.base.type;

/**
 * Created by wuxg-a on 2019/10/16.
 */

/** String str1 = "ab";
 String str2 = "abc";
 String str3 = str1+"c";
 System.out.println(str3 == str2);
 str1 与 "c" 进行字符串连接时，底层是通过StringBuffer 进行 append，生成一个StringBuffer对象，然后通过toString()方法，
 将StringBuffer对象转为String，此时会产生一个新的堆内存地址，str3指向这个新的内存地址 */
public class String1Test {
    private static final String s11="hello";
    private static final String s22="world";
    public static void main(String[] args) {
        String s1="hello";
        String s2="world";
        String s3="helloworld";
        String s4=s11+s22;
        String s5=s1+"world";
        String s6=s5.intern();
        String s7="hello"+new String("world");
        System.out.println(s3==s4);
        System.out.println(s3==s5);
        System.out.println(s4==s5);
        System.out.println(s4==s6);
        System.out.println(s3==s7);
        System.out.println(s4==s7);
        System.out.println(s5==s7);
    }
}
