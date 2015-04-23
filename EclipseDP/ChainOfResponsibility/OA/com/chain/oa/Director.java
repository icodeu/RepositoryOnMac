package com.chain.oa;

public class Director extends Leader {

	public Director(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		if (request.getLeaveDay() < 3)
			System.out.println("我是 " + getName() + ", 我可以审批3天以下的");
		else{
			System.out.println("我是 " + getName() + ", 我审批不了，传递给我的上级");
			successor.handleRequest(request);
		}
	}

}
