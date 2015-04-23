package com.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

	public static void main(String[] args) {

		CalculatorProtocol server = new Server();
		InvocationHandler handler = new CalculatorHandler(server);

		CalculatorProtocol client = (CalculatorProtocol) Proxy.newProxyInstance(server.getClass()
				.getClassLoader(), server.getClass().getInterfaces(), handler);
		
		int res = client.add(5, 3);
		System.out.println(res);
		
		res = client.sub(5, 3);
		System.out.println(res);

	}

}
