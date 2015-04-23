package com.flyweight.pure;

public class Main {

	public static void main(String[] args) {
		
		FlyWeightFactory factory = new FlyWeightFactory();
		
		IFlyWeight flyWeight1 = factory.getFlyWeight("X");
		flyWeight1.operation("EX");
		
		IFlyWeight flyWeight2 = factory.getFlyWeight("Y");
		flyWeight2.operation("EY");
		
		IFlyWeight flyWeight3 = factory.getFlyWeight("Z");
		flyWeight3.operation("EZ");
		
	}

}
