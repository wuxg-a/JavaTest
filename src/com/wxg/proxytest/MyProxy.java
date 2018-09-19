package com.wxg.proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy implements InvocationHandler{
	private UserService userService;
	
	public MyProxy(UserService userService){
		this.userService = userService;
	}
	
	public UserService createProxy(){
		UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), 
				userService.getClass().getInterfaces(), this);
		return userServiceProxy;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		 if("save".equals(method.getName())){
             System.out.println("权限校验===========");
		 }
         //return method.invoke(userService, args);
         return method.invoke(userService, args);
	}

}
