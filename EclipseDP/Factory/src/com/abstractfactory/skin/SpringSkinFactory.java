package com.abstractfactory.skin;

public class SpringSkinFactory implements ISkinFactory {

	@Override
	public IButton createButton() {
		return new SpringButton();
	}

	@Override
	public ITextField createTextField() {
		return new SpringTextField();
	}

	@Override
	public IComboBox createComboBox() {
		return new SpringComboBox();
	}

}
