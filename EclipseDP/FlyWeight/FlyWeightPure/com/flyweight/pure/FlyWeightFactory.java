package com.flyweight.pure;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightFactory {
	
	private Map<String, IFlyWeight> map = new HashMap<String, IFlyWeight>();
	
	public FlyWeightFactory() {
		map.put("X", new ConcreteFlyWeight());
		map.put("Y", new ConcreteFlyWeight());
		map.put("Z", new ConcreteFlyWeight());
	}
	
	public IFlyWeight getFlyWeight(String key){
		return map.get(key);
	}

}
