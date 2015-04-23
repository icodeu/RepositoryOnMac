package com.decorator.windowcomponent;

public class BlackBorderDecorator extends IComponentDecorator {

	private IComponent component;
	
	public BlackBorderDecorator(IComponent component) {
		super(component);
		this.component = component;
	}
	
	@Override
	public void display() {
		super.display();
		setBlackBorder();
	}
	
	public void setBlackBorder(){
		System.out.println("为" + component.getName() + "增加黑色滚动条");
	}

}
