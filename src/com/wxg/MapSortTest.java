package com.wxg;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


public class MapSortTest {

	public static void main(String[] args) {
		
		HashMap<String,Double> orimap = new HashMap<>();
		orimap.put("1", 100.0);
		orimap.put("3", 300.0);
		orimap.put("2", 200.0);
		orimap.put("2", 220.0);
		
		ValueComparator valueComparator = new ValueComparator(orimap);
		
		TreeMap<String,Double> sortMap = new TreeMap<>(valueComparator);
		
		sortMap.putAll(orimap);
		
		//printMap(orimap);
		
		printMap(sortMap);
		
	}
	
	private static void printMap(Map map){
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
