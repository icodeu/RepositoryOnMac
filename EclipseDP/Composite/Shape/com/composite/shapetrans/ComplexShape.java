package com.composite.shapetrans;

import java.util.ArrayList;
import java.util.List;

public class ComplexShape extends IShape {
	
	private List<IShape> lists = new ArrayList<IShape>();
	
	public ComplexShape(String name) {
		this.name = name;
	}

	@Override
	public void add(IShape shape) {
		lists.add(shape);
	}

	@Override
	public void remove(IShape shape) {
		lists.remove(shape);
	}

	@Override
	public void draw() {
		System.out.print("I am ComplexShape, I draw >> ");
		for (IShape shape : lists) {
			System.out.print(shape.name + " ");
		}
		System.out.println();
	}

}
