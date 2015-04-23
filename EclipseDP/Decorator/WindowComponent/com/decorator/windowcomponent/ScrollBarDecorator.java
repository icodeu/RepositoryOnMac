package com.decorator.windowcomponent;

public class ScrollBarDecorator extends IComponentDecorator {

	private IComponent component;
	
	public ScrollBarDecorator(IComponent component) {
		super(component);
		this.component = component;
	}
	
	@Override
	public void display() {
		super.display();
		setScrollBar();
	}
	
	// 既然是装饰了 那就要增加新的功能
	public void setScrollBar(){
		System.out.println("为" + component.getName()  + "增加滚动条");
	}


}
