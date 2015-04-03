package com.factorymethod.mobilecard;

/*
 * 工厂方法模式 》》》 工厂方法的隐藏
 */
public class Main {

	public static void main(String[] args) {
		ICardFactory factory = null;
		ICharge charge = null;

		factory = new GotoneFactory();
		factory.charge();
		
		factory = new MZoneFactory();
		factory.charge();
		
		factory = new ShenZhouFactory();
		factory.charge();
		
	}

}
