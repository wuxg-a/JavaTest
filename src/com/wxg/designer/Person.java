package com.wxg.designer;

public class Person {
	private PersonListener listener; 
	public void run() { 
		if (listener != null) { 
			listener.doRun(new Even(this)); 
		} 
		System.out.println("run........"); 
	} 
	public void eat() { 
		if (listener != null) { 
			listener.doEat(new Even(this)); 
		} 
		System.out.println("eat........"); 
	}
	// 注册监听器 
	public void registerListener(PersonListener listener) 
		{ 
			this.listener = listener; 
		} 
}
