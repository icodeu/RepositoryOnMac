package com.factorymethod.mobilecard;

public abstract class ICardFactory {

	public abstract ICharge createCard();
	
	public void charge(){
		ICharge charge = this.createCard();
		charge.charge();
	}
	
	
	
}
