package com.wxg.name.hide;

public class NameHide {
	public static void main(String[] args) {
		Bart b = new Bart();
		b.doh(1); // doh(float) used
		b.doh('x');
		b.doh(1.0f);
		b.doh(new Milhouse());
		}
}
