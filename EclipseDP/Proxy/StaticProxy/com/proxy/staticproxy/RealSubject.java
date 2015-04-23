package com.proxy.staticproxy;

public class RealSubject implements Subject {

	@Override
	public void request() {
		System.out.println("Call RealSubject.request()");
	}

}
