package com.adapter.mathpower;

public class Adapter implements ITarget {
	
	Adaptee adaptee = new Adaptee();

	@Override
	public double square(double number) {
		return adaptee.power(number, 2);
	}


}
