package com.abstractfactory.skin;

public interface ISkinFactory {
	
	public IButton createButton();
	public ITextField createTextField();
	public IComboBox createComboBox();

}
