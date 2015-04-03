package com.abstractfactory.skin;

public class SummerSkinFactory implements ISkinFactory {

	@Override
	public IButton createButton() {
		return new SummerButton();
	}

	@Override
	public ITextField createTextField() {
		return new SummerTextField();
	}

	@Override
	public IComboBox createComboBox() {
		return new SummerComboBox();
	}

}
