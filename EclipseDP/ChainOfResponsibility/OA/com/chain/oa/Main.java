package com.chain.oa;

public class Main {

	public static void main(String[] args) {

		Leader director = new Director("主任");
		Leader manager = new Manager("经理");
		Leader generalManager = new GeneralManager("总经理");
		
		director.setSuccessor(manager);
		manager.setSuccessor(generalManager);
		
		LeaveRequest request = new LeaveRequest();
		request.setLeaveDay(25);
		
		director.handleRequest(request);
		
	}

}

// 逐级设领导，handleRequest()时不满足就交给上级领导继续处理
