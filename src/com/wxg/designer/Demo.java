package com.wxg.designer;

public class Demo {
	public static void main(String[] args){
		Person p = new Person(); 
		p.registerListener(new PersonListener() {
			@Override
			public void doRun(Even e) {
				System.out.println(e.getP() + " is running"); 
			}

			@Override
			public void doEat(Even e) {
				System.out.println(e.getP() + " is eatting");
			}
			
		});
		p.run(); 
		p.eat(); 
	}
}
