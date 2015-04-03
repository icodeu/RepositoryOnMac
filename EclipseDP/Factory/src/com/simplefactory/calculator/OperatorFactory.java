package com.simplefactory.calculator;

public class OperatorFactory {
	
	public static Operation createOperation(char op){
		if (op == '+')
			return new OperateAdd();
		if (op == '-')
			return new OperateSub();
		return null;
	}

}
