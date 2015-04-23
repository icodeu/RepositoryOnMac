package com.bridge.message;

public class CommonMessage extends MessageAbstract {

	public CommonMessage(MessageImplementor implementor) {
		super(implementor);
	}
	
	@Override
	public void sendMessage(String message, String toUser) {
		super.sendMessage(message, toUser);
	}

}
