package com.adapter.duckturkey;

public class TurkeyAdapter implements IDuck {

	ITurkey turkey = new WildTurkey();
	
	@Override
	public void quack() {
		turkey.gobble();
	}

	@Override
	public void fly() {
		turkey.fly();
	}

}
