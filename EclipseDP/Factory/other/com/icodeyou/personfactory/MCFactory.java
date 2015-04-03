package com.icodeyou.personfactory;

public class MCFactory implements IPersonFactory {

	@Override
	public IBoy getBoy() {
		return new MCBoy();
	}

	@Override
	public IGirl getGirl() {
		return new MCGirl();
	}

}
