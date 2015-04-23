package com.decorator.windowcomponent;


public class Main {

	public static void main(String[] args) {
		IComponent component = null;
		IComponentDecorator decorator = null;
		
		component = new Window();
		
		decorator = new ScrollBarDecorator(component);
		decorator.display();
		
		decorator = new BlackBorderDecorator(component);
		decorator.display();
	}

}
