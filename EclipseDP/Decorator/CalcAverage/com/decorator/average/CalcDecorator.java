package com.decorator.average;

public abstract class CalcDecorator {

	private Average average;
	
	public CalcDecorator(Average average) {
		this.average = average;
	}
	
	public void calc() {
		average.calc();
	}
	
}
