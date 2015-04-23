package com.decorator.average;

import java.util.List;

public class Average {
	
	private List<Integer> data;
	
	public Average(List<Integer> data) {
		this.data = data;
	}
	
	public double calc(){
		int sum = 0;
		for (int i=0;i<data.size();i++){
			sum += data.get(i);
		}
		double aveRes = (double)(sum) / data.size();
		System.out.println("平均值为 : " + aveRes);
		return aveRes;
	}
	
	public List<Integer> getData() {
		return data;
	}

}
