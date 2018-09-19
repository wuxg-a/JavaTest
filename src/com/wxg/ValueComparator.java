package com.wxg;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator<String>{
	Map<String,Double> base;
	
	public ValueComparator(Map<String,Double> base) {
		this.base = base;
	}
	
	@Override
	public int compare(String s1, String s2) {
		if(base.get(s1) >= base.get(s2)){
			return 1;
		}else{
			return -1;
		}
	}
}
