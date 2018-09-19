package com.wxg.test;

import java.util.HashMap;
import java.util.Map.Entry;


public class MainTest {
	
	public static void main(String[] args) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		for(int i=1; i<126; i++){
			
			hashMap.put(String.valueOf(i), "value:" + String.valueOf(i));
		}
		
		for(Entry<String, String> entry: hashMap.entrySet()){
			System.out.println(entry.getKey() + ";" + entry.getValue());
		}
		
	}
	
}
