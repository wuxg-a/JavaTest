package com.wxg.test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		 List<String> list = new ArrayList<String>();
		 list.add("val1");
		 list.add("val2");
		 
		 Map<String,String> map = new HashMap<String,String>();
		 map.put("val1", "val1");
		 map.put("val2", "val2");
		 
		 Set<String> set = new HashSet<String>();
		 
		 List<String> listTmp = new ArrayList<String>();
		 listTmp.addAll(list);
 		 set.addAll(list);
		 System.out.println(set);
	}
}
