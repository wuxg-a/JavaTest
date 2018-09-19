package com.wxg.thread;


public class Test {

	public static void main(String[] args) {
//		MyRunnable task = new MyRunnable("A");
//		new Thread(task).start();
//		new Thread(task).start();		
//		new MyThread("A").start();
//		new MyThread("B").start();
		
		System.out.println(Thread.currentThread().getName()+"线程start");
		
		final int count = 10;
		new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i=0; i< count; i++){
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(i);
				}
			}
		
		}).start();

		System.out.println(Thread.currentThread().getName()+"线程end");
		final String str = "pae";
		fun(str);
		
	}

	private static void fun(String param1){

	}

}
