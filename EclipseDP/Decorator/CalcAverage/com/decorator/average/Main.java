package com.decorator.average;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> data = new ArrayList<Integer>();
		for (int i=0;i<10;i++)
			data.add(i);
		
		Average average = null;
		CalcDecorator decorator = null;
		
		average = new Average(data);
		
		decorator = new GreaterDecorator(average);
		decorator.calc();
		
		decorator = new VarianceDecorator(average);
		decorator.calc();
		
	}

}
