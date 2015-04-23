package com.interpreter.robot;

public class DistanceNode implements AbstractNode {

	private String distance;
	
	public DistanceNode(String distance) {
		this.distance = distance;
	}

	@Override
	public String interpret() {
		return distance;
	}

}
