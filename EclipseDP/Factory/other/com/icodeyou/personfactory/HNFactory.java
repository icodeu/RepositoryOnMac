package com.icodeyou.personfactory;

public class HNFactory implements IPersonFactory {

	@Override
	public IBoy getBoy() {
		return new HNBoy();
	}

	@Override
	public IGirl getGirl() {
		return new HNGirl();
	}

}
