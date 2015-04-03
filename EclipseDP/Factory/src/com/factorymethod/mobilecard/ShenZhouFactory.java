package com.factorymethod.mobilecard;

public class ShenZhouFactory extends ICardFactory {

	@Override
	public ICharge createCard() {
		return new ShenZhou();
	}

}
