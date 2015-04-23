package com.decorator.windowcomponent;

public class ListBox implements IComponent {
	
	private String name = "列表框";

	@Override
	public void display() {
		System.out.println("显示列表框");
	}
	
	public String getName() {
		return name;
	}

}
