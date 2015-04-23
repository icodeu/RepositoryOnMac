package com.bridge.message;

public class Main {

	public static void main(String[] args) {

		String message = "Hello DesignPattern";
		String toUser = "wanghuan";
		
		MessageImplementor implementor = null;
		MessageAbstract abstractor = null;
		
		implementor = new MessageSMS();
		abstractor = new CommonMessage(implementor);
		abstractor.sendMessage(message, toUser);
		
		implementor = new MessageEmail();
		abstractor = new UrgencyMessage(implementor);
		abstractor.sendMessage(message, toUser);
		
		
	}

}
