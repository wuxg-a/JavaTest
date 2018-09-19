package com.wxg.thread.syn;

public class SynObj {
	
	public synchronized void methodA() {
        System.out.println("methodA.....");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void methodB() {
        synchronized(this) {
            System.out.println("methodB.....");
        }
    }

    public void methodC() {
        String str = "sss";
        synchronized (str) {
            System.out.println("methodC.....");
        }
    }
}
