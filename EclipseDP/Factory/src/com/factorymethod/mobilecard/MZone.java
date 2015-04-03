package com.factorymethod.mobilecard;

public class MZone implements ICharge {

	@Override
	public void charge() {
		System.out.println("MZone is Charging");
	}

}
