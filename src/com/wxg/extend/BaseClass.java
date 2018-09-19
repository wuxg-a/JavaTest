package com.wxg.extend;

public class BaseClass implements InterFace{
	private String str;
	
	private void print(){
		
	}
	BaseClass(String str){
		this.str = str;	
	}
	protected String getStr(){
		return this.str;
	}
	@Override
	public void method() {
		System.out.println("---BaseClass:method()---");		
	}
}
