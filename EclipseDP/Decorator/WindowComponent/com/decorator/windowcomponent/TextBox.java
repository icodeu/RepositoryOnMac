package com.decorator.windowcomponent;

public class TextBox implements IComponent {
	
	private String name = "文本框";

	@Override
	public void display() {
		System.out.println("显示文本框");
	}
	
	public String getName() {
		return name;
	}

}
