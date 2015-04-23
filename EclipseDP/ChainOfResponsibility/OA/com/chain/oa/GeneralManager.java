package com.chain.oa;

public class GeneralManager extends Leader {

	public GeneralManager(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		if (request.getLeaveDay() >= 10 && request.getLeaveDay() <= 30)
			System.out.println("我是 " + getName() + ", 我可以审批10-30天的");
		else{
			System.out.println("我是 " + getName() + ", 我审批不了，无上级可传，只能拒绝了");
		}
	}

}
