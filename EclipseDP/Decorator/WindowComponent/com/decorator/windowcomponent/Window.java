package com.decorator.windowcomponent;

public class Window implements IComponent {

	private String name = "窗体";
	
	@Override
	public void display() {
		System.out.println("显示窗体");
	}
	
	public String getName() {
		return name;
	}

}
