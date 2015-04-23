package com.bridge.message;

public abstract class MessageAbstract {

	private MessageImplementor implementor;
	
	public MessageAbstract(MessageImplementor implementor) {
		this.implementor = implementor;
	}
	
	public void sendMessage(String message, String toUser){
		this.implementor.send(message, toUser);
	}
	
}
