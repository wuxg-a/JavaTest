package com.wxg.extend;

public class FinalTest extends FinalTestBase{

	private void print(){
		System.out.println("FinalTest");
	}
	
	public static void main(String[] args) {
		FinalTest test = new FinalTest();
		test.print();
	}
}
