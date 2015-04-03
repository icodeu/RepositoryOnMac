package com.adapter.objectadapter;

public class Adapter implements ITarget {

	public Adaptee adaptee = new Adaptee();
	
	@Override
	public void request() {
		adaptee.specificRequest();
	}

}
