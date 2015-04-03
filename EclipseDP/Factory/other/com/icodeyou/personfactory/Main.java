package com.icodeyou.personfactory;

public class Main {

	public static void main(String[] args) {
		IPersonFactory factory = new HNFactory();
		IBoy boy = factory.getBoy();
		boy.drawMan();
	}

}
