package com.interpreter.calculator;

public class ModNode extends SymbolNode {
	
	private Node left;
	private Node right;
	
	public ModNode(Node left, Node right) {
		super(left, right);
		this.left = left;
		this.right = right;
	}

	@Override
	public int interpret() {
//		System.out.println("计算 " + left.interpret() + "%" + right.interpret());
		return left.interpret() % right.interpret();
	}

}
