package com.wxg.base.type;

/**
 * Created by wuxg-a on 2019/10/16.
 */
public class LongTest {

    public static void main(String[] args) {
        Long long1 = 200L;
        Long long2 = 200L;
        System.out.println("=" + (long1 == long2));
        System.out.println(long1.equals(long2));

        //-127-128会缓存，所以相等
        Long long3 = 100L;
        Long long4 = 100L;
        System.out.println("=" + (long3 == long4));
        System.out.println(long3.equals(long4));

        Long long5 = new Long(100L);
        Long long6 = new Long(100L);
        System.out.println("=" + (long5 == long6));
        System.out.println(long5.equals(long6));

    }
}
