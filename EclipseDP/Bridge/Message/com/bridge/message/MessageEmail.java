package com.bridge.message;

public class MessageEmail implements MessageImplementor {

	@Override
	public void send(String message, String toUser) {
		System.out.println("使用EMAIL方式发送 " + message + " 给 " + toUser);
	}

}
