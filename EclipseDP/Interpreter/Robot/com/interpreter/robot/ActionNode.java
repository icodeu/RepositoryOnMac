package com.interpreter.robot;

public class ActionNode implements AbstractNode {

	private String action;
	
	public ActionNode(String action) {
		this.action = action;
	}

	@Override
	public String interpret() {
		if (action.equalsIgnoreCase("move")){
			return "移动";
		}
		if (action.equalsIgnoreCase("run")){
			return "快速移动";
		}
		return "无效的动作指令";
	}

}
