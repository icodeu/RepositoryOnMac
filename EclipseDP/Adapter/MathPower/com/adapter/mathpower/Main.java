package com.adapter.mathpower;

public class Main {

	public static void main(String[] args) {
		
		double number = 4;
		
		ITarget target = new Adapter();
		double res = target.square(number);
		System.out.println(res);
		
	}

}
