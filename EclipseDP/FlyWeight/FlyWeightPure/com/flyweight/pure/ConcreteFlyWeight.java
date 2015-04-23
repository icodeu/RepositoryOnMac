package com.flyweight.pure;

public class ConcreteFlyWeight implements IFlyWeight {

	// 共享的内部状态
	private String inState = "IN";
	
	// 非共享的外部状态传入
	@Override
	public void operation(String exState) {
		System.out.println("INSTATE : " + inState);
		System.out.println("EXSTATE : " + exState);
	}

}
