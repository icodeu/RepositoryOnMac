package com.interpreter.calculator;

public class Main {

	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		String instruction = "3 * 4 / 2 % 4";
		
		calculator.calculate(instruction);
		int res = calculator.output();
		System.out.println(res);
		
	}

}

// 在解释时本质上类似于 栈的递归
