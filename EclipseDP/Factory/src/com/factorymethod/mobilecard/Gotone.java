package com.factorymethod.mobilecard;

public class Gotone implements ICharge {

	@Override
	public void charge() {
		System.out.println("Gotone is Charging");
	}

}
