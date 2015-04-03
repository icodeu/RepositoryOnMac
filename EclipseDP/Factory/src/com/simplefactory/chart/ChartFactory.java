package com.simplefactory.chart;

import java.util.HashMap;
import java.util.Map;

public class ChartFactory {
	
	public static IChart getChart(String className){
		try {
			IChart chart = (IChart) Class.forName(className).newInstance();
			return chart;
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static IChart getChartByKey(String key){
		Map<String, String> map = new PropertiesReader().getProperties();
		try {
			IChart chart = (IChart) Class.forName(map.get(key)).newInstance();
			return chart;
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
