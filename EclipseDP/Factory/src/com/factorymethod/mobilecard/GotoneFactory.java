package com.factorymethod.mobilecard;

public class GotoneFactory extends ICardFactory {

	@Override
	public ICharge createCard() {
		return new Gotone();
	}

}
