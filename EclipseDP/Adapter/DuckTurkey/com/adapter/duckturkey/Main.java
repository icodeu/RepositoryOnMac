package com.adapter.duckturkey;

public class Main {

	public static void main(String[] args) {

		IDuck duck = new MallardDuck();
		duck.quack();
		duck.fly();
		
		// Use TurkeyAdapter
		duck = new TurkeyAdapter();
		duck.quack();
		duck.fly();
		
	}

}
