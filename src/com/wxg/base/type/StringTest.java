package com.wxg.base.type;

/**
 * Created by wuxg-a on 2019/10/16.
 */
public class StringTest {
    public static final String fs1="abc";
    public static final String fs2="def";

    public static final String fns1;
    public static final String fns2;

    static{
        fns1="abc";
        fns2="def";
    }

    public static void main(String[] args) {
        String s1="abc1";//此处是数字1
        String s2="abc"+1;
        System.out.println(s1==s2);// 第一次比较
        String s3="ab";
        String s4="c";
        String s5="abc";
        String s6=s3+s4;
        System.out.println(s5==s6);// 第二次比较

        //final
        String fs3=fs1+fs2;
        String fs4="abcdef";
        System.out.println(fs3==fs4);

        //final未初始化
        String fns3=fns1+fns2;
        String fns4="abcdef";
        System.out.println(fns3==fns4);

        //intern
        String is1=new String("abcdefg");
        String is2=s1.intern();
        String is3="abcdefg";
        System.out.println(is2==is3);

    }
}
