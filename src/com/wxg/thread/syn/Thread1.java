package com.wxg.thread.syn;

public class Thread1 implements Runnable{
	
	private int count = 100;
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		new Thread(t1, "A").start();
		new Thread(t1, "B").start();
		new Thread(t1, "C").start();

	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			//System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
			synchronized (this){
				System.out.println(Thread.currentThread().getName()+":当前剩余票数为："+ count--);
			}
				
		}
			
	}
}
