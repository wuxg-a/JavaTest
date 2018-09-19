package com.wxg;

import java.util.Iterator;
import java.util.LinkedList;

public class MyQueue<T> {
	
	private LinkedList<T> list;
	
	public MyQueue(){
		list = new LinkedList<>();
	}
	
	public void add(T t){
		list.addLast(t);
	}
	
	public <E>E get (){
		return (E) list.removeFirst();
	}
	
	public Iterator iterator(){
		return list.iterator();
	}
	
	
}
