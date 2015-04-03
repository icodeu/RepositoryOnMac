package com.icodeyou.factory;

import java.util.Map;

public class HairFactory {
	
	public IHair getHair(String key){
		if ("left".equals(key)){
			return new LeftHair();
		}else if ("right".equals(key)){
			return new RightHair();
		}
		return null;
	}
	
	public IHair getHairByClass(String className){
		IHair iHair = null;
		try {
			iHair = (IHair) Class.forName(className).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		return iHair;
	}

	public IHair getHairByClassKey(String key){
		IHair iHair = null;
		Map<String, String> map = new PropertiesReader().getProperties();
		try {
			iHair = (IHair) Class.forName(map.get(key)).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		return iHair;
	}
	
}
