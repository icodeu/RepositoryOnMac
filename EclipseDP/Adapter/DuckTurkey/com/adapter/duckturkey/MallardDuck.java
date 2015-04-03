package com.adapter.duckturkey;

public class MallardDuck implements IDuck {

	@Override
	public void quack() {
		System.out.println("I am MallardDuck, 嘎嘎嘎~");
	}

	@Override
	public void fly() {
		System.out.println("I am MallardDuck, fly~");
	}

}
