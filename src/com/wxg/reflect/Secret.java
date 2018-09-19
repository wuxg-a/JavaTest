package com.wxg.reflect;

public class Secret {
	
	private String secrecy;
	
	public Secret( String secrecy){
		this.secrecy = secrecy;
	}
	public String getSecrecy(){
		System.out.println(secrecy);
		return this.secrecy;
	}
}
