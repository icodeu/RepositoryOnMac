package com.chain.oa;

public class Manager extends Leader {

	public Manager(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		if (request.getLeaveDay() >= 3 && request.getLeaveDay() <= 10)
			System.out.println("我是 " + getName() + ", 我可以审批3-10天的");
		else{
			System.out.println("我是 " + getName() + ", 我审批不了，传递给我的上级");
			successor.handleRequest(request);
		}
	}

}