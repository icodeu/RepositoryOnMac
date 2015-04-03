package com.adapter.objectadapter;

public class Main {

	public static void main(String[] args) {
		
		ITarget target = new Adapter();
		target.request();
		
	}

}
