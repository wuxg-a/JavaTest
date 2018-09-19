package com.wxg;

import java.util.Iterator;
import java.util.LinkedList;

public class MyStatck {
		
		LinkedList<String> list;
		public MyStatck(){
			list = new LinkedList<String>();
		}
		
		public void add(String str){
			list.addFirst(str);
		}
		
		public String get(){
			return list.removeFirst();
		}
		
		public boolean isNull(){
			return list.isEmpty();
		}
		
		public Iterator iterator(){
			return list.iterator();
		}
		
 	}
