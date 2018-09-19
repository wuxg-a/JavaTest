package com.wxg.proxytest;


public class MainTest {

	public static void main(String[] args) {
		UserService userService = new UserServiceImpl1();
		UserService proxy = new MyProxy(userService).createProxy();
		proxy.save();
		//proxy.update();
	}

}
