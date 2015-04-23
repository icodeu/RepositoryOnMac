package com.bridge.message;

public class UrgencyMessage extends MessageAbstract {

	public UrgencyMessage(MessageImplementor implementor) {
		super(implementor);
	}
	
	@Override
	public void sendMessage(String message, String toUser) {
		message = "【加急消息】 " + message;
		super.sendMessage(message, toUser);
	}
	
	// 可以扩展自己的新功能
	public void watch(){
		System.out.println("正在等待回应 watching");
	}
	
	

}
