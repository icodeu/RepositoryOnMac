package com.decorator.windowcomponent;

public abstract class IComponentDecorator {
	
	private IComponent component;
	
	public IComponentDecorator(IComponent component){
		this.component = component;
	}
	
	public void display(){
		component.display();
	}

}
