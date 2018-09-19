package com.wxg.designpattern.adapter;

public class MainTest {

	public static void main(String[] args) {
		Adapter adapter = new Adapter();
		request(adapter);
	}
	public static void request(Target target){
		target.request();
	}
}
