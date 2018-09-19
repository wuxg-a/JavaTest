package com.wxg.test;
import com.wxg.InnerObjectTest;


public class InnerObjectMain {
	InnerObjectTest innerObject;
	int a;
	boolean str;
	InnerObjectMain(){
		innerObject = new InnerObjectTest();
		System.out.println("InnerObjectMain Construct");
	}
	public void print(){
		System.out.println("a:"+a);
		System.out.println("str:"+str);
		System.out.println("innerObject:"+innerObject.getStr());
	}
	public static void main(String[] args) {
		InnerObjectMain innerObjectMain=new InnerObjectMain();
	    innerObjectMain.print();

	}

}
