package com.flyweight.bus;

import java.util.HashMap;
import java.util.Map;

public class BusFactory {
	
	private static BusFactory instance = new BusFactory();
	private static Map<String, Bus> map;
	
	private BusFactory(){
		map = new HashMap<String, Bus>();
		map.put("A", new Bus("A"));
		map.put("B", new Bus("B"));
		map.put("C", new Bus("C"));
		map.put("D", new Bus("D"));
	}
	
	public static Bus getBus(String key){
		return map.get(key);
	}
	
	public static BusFactory getInstance(){
		if (instance != null){
			instance = new BusFactory();
		}
		return instance;
	}

}