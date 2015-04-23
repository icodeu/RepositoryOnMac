package com.mediator.colleague;

public class ColleagueB extends AbstractColleague {

	public ColleagueB(AbstractMediator mediator) {
		super(mediator);
	}
	
	public void self(){
		System.out.println("B : 做好分内工作");
	}
	
	public void out(){
		System.out.println("B : 请求A做好分内工作");
		super.mediator.execute("ColleagueA", "self");
	}

}
