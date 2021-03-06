package com.composite.shapetrans;

public class Line extends IShape {
	
	public Line(String name) {
		this.name = name;
	}

	@Override
	public void add(IShape shape) {
		System.out.println("I am Line, can not add " + shape.name);
	}

	@Override
	public void remove(IShape shape) {
		System.out.println("I am Line, can not remove " + shape.name);
	}

	@Override
	public void draw() {
		System.out.println("I draw >> " + name);
	}

}
