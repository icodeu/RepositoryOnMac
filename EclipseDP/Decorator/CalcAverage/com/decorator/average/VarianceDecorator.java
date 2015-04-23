package com.decorator.average;

import java.util.List;

public class VarianceDecorator extends CalcDecorator {

	private Average average;
	
	public VarianceDecorator(Average average) {
		super(average);
		this.average = average;
	}
	
	@Override
	public void calc() {
		super.calc();
		calcVariance();
	}
	
	public void calcVariance(){
		double ave = average.calc();
		List<Integer> data = average.getData();
		double squareSum = 0;
		for (int i=0;i<data.size();i++){
			squareSum += Math.pow((data.get(i) - ave), 2);
		}
		double varRes = squareSum / data.size();
		System.out.println("方差为 : " + varRes);
	}

}
