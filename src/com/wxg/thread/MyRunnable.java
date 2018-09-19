package com.wxg.thread;

public class MyRunnable implements Runnable{
	private String name;
    private int count=15;
    public MyRunnable(String name){
    	this.name=name;
    }
	@Override
	public void run() {
		  for (int i = 0; i < 5; i++) {
			  System.out.println(Thread.currentThread().getName() + "运行  count= " + count--);
	            try {
	            	Thread.sleep((int) Math.random() * 10);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
		
	}
	
}
