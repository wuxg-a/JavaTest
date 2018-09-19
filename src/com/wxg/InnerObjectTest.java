package com.wxg;

public class InnerObjectTest {
	private String str;
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public InnerObjectTest(){
		System.out.println("InnerObjectTest Construct");
		str = new String("Construct");
	}
//	public String toString(){
//		return str;
//	}
}
