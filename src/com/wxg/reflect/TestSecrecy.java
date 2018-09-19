package com.wxg.reflect;

import java.lang.reflect.Method;

public class TestSecrecy {
	
	public static void main(String[] args) {
		Secret secrect = new Secret("TOP SECRET");
		try {
			//Field field = Secret.class.getDeclaredField("secrecy");
			Method method =Secret.class.getMethod("getSecrecy", null);
			//System.out.println(method.toString());
			method.invoke(secrect, null);
			//field.setAccessible(true);
			//System.out.println(field.get(secrect));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
