package com.adapter.duckturkey;

public class WildTurkey implements ITurkey {

	@Override
	public void gobble() {
		System.out.println("I am Turkey, 咕咕咕~");
	}

	@Override
	public void fly() {
		System.out.println("I am Turkey, fly~");
	}

}