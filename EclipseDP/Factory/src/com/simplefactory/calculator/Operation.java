package com.simplefactory.calculator;

public abstract class Operation {
	
	public double operatorA;
	public double operatorB;
	
	public abstract double calc();
	
	public void setOperatorA(double opA){
		operatorA = opA;
	}
	
	public void setOperatorB(double opB){
		operatorB = opB;
	}

}
