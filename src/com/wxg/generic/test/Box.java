package com.wxg.generic.test;

public class Box<T> {
	private T data;
	
	public Box(){
		
	}
	
	public Box(T data){
		this.data = data;
	}
	
	public T getData(){
		return this.data;
	}

	public static void getData(Box<? extends Fruit> data){
		System.out.println("data :" + data.getData());
	}
}
