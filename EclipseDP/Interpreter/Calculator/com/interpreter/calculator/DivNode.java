package com.interpreter.calculator;

public class DivNode extends SymbolNode {
	
	private Node left;
	private Node right;
	
	public DivNode(Node left, Node right) {
		super(left, right);
		this.left = left;
		this.right = right;
	}

	@Override
	public int interpret() {
//		System.out.println("计算 " + left.interpret() + "/" + right.interpret());
		return left.interpret() / right.interpret();
	}

}
