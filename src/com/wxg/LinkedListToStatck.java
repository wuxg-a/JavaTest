package com.wxg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class LinkedListToStatck {

	public static void main(String[] args) {
		MyStatck ms = new MyStatck();
		//Queue<String> ms = new Queue<String>();
		ms.add("1");
		ms.add("2");
		System.out.println("出："+ms.get());
		ms.add("3");
		System.out.println("出："+ms.get());
		ms.add("4");
		
		Iterator<String> it = ms.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	

}
