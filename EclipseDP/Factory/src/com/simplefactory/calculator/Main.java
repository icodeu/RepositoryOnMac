package com.simplefactory.calculator;

public class Main {

	public static void main(String[] args) {
		double result;
		
		double opA = 4;
		double opB = 3;
		char op = '-';
		
		Operation operation = OperatorFactory.createOperation(op);
		operation.setOperatorA(opA);
		operation.setOperatorB(opB);
		result = operation.calc();
		
		System.out.println(result);
	}

}
