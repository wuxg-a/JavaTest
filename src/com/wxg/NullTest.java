package com.wxg;

import com.google.common.base.Optional;

public class NullTest {

	public static void main(String[] args) {
		final int[][] t_size = new int[][]{
				{1, 2}, {3, 4}, {5, 6}
		};
		System.out.println(t_size[2][0]);
	}
	
	public static void testOptional() throws Exception { 
        Optional<Integer> possible=Optional.of(null);
        if(possible.isPresent()){
            System.out.println("possible isPresent:"+possible.isPresent());
            System.out.println("possible value:"+possible.get());
        }
    } 
}
