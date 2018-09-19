package com.wxg.generic.test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

	public static void main(String[] args) {
		
		
		Box<Apple> name = new Box<Apple>();
		Box<Orange> age = new Box<Orange>();

		Box.getData(name);
		Box.getData(age);

		// producer
		List<? extends Fruit> fruits = new ArrayList<>();

	}
	

}
