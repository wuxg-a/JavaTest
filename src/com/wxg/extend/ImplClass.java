package com.wxg.extend;

public class ImplClass extends BaseClass{
	String data;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public ImplClass(String data2) {
		super("str");
		this.data = data2;
		
	}
	public static void main(String[] args) {
		ImplClass implClass = new ImplClass("ImplClass Test");
		Class<? extends Object> clazzes = implClass.getClass();
		System.out.println(clazzes);
		//BaseClass baseClass = new BaseClass("BaseClass Test");
		//implClass.print(implClass);
		//implClass.print(baseClass);
	}
	
	public void method() {
		System.out.println("---ImplClass:method()---");		
	}
	public void print(InterFace inter){
		inter.method();
	}
}
