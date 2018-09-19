package com.wxg.staticinit;

public class Cupboard {
	static Bowl b4 = new Bowl(4);
	Cupboard() {
	System.out.println("Cupboard()");
	b4.f(2);
	}
	void f3(int marker) {
	System.out.println("f3(" + marker + ")");
	}
	static Bowl b5 = new Bowl(5);
}
