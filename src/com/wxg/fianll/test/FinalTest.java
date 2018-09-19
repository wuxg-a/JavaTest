package com.wxg.fianll.test;

/**
 * Created by wuxg-a on 2017/7/24.
 */
public class FinalTest {
    public static void main(String[] args) {

        print(new Bird() {
            @Override
            public int fly() {
                return 1000;
            }
        });
    }
    public static void print(Bird bird){
        System.out.println(bird.fly());
    }

    private static int transform(final int str){
        return str + 2;
    }
}
