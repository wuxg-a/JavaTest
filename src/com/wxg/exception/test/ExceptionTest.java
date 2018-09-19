package com.wxg.exception.test;

public class ExceptionTest {

	public static void main(String[] args) {
		
		try {
			int res=div(2,0);
		} catch (Exception e) {
			System.out.println("-------Main-----");
		}
	}
	public static int div(int param1 , int param2){
		
		int result = 0;
		try {
			result = (int)param1/param2;
		} catch (Exception e) {
			System.out.println("--------div--------");
		}
		System.out.println("----after catch exception of div--------");
		return result;
	}
}
