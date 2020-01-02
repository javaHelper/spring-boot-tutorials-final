package com.example;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

public class Demo {
	public static void main(String[] args) {
		MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
		map.put("key1", "value1");
		map.put("key1", "value2");
		map.put("key1", "value2");
		
		System.out.println(map);
	}
}
