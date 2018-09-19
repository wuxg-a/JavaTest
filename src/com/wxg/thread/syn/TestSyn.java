package com.wxg.thread.syn;

public class TestSyn {
	
	public static void main(String[] args) {
        final SynObj obj = new SynObj();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.methodA();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.methodB();
            }
        });
        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.methodC();
            }
        });
        t3.start();
    }
}
