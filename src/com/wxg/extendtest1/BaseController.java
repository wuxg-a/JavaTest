package com.wxg.extendtest1;

/**
 * Created by wuxg-a on 2019/3/29.
 */
public class BaseController {

    public int num = 1;

    public int getNum() {
        System.out.println("Base:" + this.num);
        return num;
    }


    public static void main(String[] args) {

        try {
            int a = 100;
            _testExceptionAsyn();
            System.out.println("this a is :" + a);
        } catch (Exception e) {
            System.out.println("catch exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void _testExceptionAsyn() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("test exception in asyn");
            }
        }).start();
    }

}
