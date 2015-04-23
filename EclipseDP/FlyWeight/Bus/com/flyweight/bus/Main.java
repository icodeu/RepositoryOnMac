package com.flyweight.bus;

public class Main {

	public static void main(String[] args) {
		
		BusFactory factory = BusFactory.getInstance();
		Bus bus1, bus2;
		
		bus1 = factory.getBus("A");
		bus2 = factory.getBus("A");
		
		System.out.println("bus1 == bus2 ? " + (bus1 == bus2));
		
	}

}

// 本质上就是在一个工厂中维护一个集合  客户端直接从集合中按key取出value