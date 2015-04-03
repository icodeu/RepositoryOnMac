package com.abstractfactory.skin;

public class Main {

	public static void main(String[] args) {
		ISkinFactory factory = null;
		IButton button = null;
		ITextField textField = null;
		IComboBox comboBox = null;
		
		factory = new SpringSkinFactory();   // 若要更改 在这里改为 new SummerSkinFactory()
		button = factory.createButton();
		textField = factory.createTextField();
		comboBox = factory.createComboBox();
		
		button.display();
		textField.display();
		comboBox.display();
		
		// Read XML config
		factory = (ISkinFactory) XMLUtil.getBean();
		button = factory.createButton();
		textField = factory.createTextField();
		comboBox = factory.createComboBox();
		
		button.display();
		textField.display();
		comboBox.display();
	}

}
