package com.composite.shapetrans;

public class Circle extends IShape {
	
	public Circle(String name) {
		this.name = name;
	}

	@Override
	public void add(IShape shape) {
		System.out.println("I am Circle, can not add " + shape.name);
	}

	@Override
	public void remove(IShape shape) {
		System.out.println("I am Circle, can not remove " + shape.name);
	}

	@Override
	public void draw() {
		System.out.println("I draw >> " + name);
	}

}
