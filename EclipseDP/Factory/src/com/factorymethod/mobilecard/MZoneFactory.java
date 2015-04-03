package com.factorymethod.mobilecard;

public class MZoneFactory extends ICardFactory {

	@Override
	public ICharge createCard() {
		return new MZone();
	}

}
