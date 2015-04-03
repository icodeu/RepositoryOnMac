package com.icodeyou.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/*
 * Properties 
 */
public class PropertiesReader {
	
	private static final String PROPS_NAME = "type.properties";
	
	public Map<String, String> getProperties(){
		Properties props = new Properties();
		Map<String, String> map = new HashMap<String, String>();
		try{
			InputStream in = getClass().getResourceAsStream(PROPS_NAME);
			props.load(in);
			Enumeration en = props.propertyNames();
			while (en.hasMoreElements()){
				String key = (String) en.nextElement();
				String property = props.getProperty(key);
				map.put(key, property);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return map;
	}

}
