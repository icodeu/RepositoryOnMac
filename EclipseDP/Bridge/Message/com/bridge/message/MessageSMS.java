package com.bridge.message;

public class MessageSMS implements MessageImplementor {

	@Override
	public void send(String message, String toUser) {
		System.out.println("使用SMS方式发送 " + message + " 给 " + toUser);
	}

}
