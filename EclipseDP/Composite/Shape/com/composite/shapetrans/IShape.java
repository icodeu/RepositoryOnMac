package com.composite.shapetrans;

/*
 * 透明式 组合
 */
public abstract class IShape {
	
	public String name;
	
	public abstract void add(IShape shape);
	
	public abstract void remove(IShape shape);
	
	public abstract void draw();

}
