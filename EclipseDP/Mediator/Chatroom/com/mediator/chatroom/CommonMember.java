package com.mediator.chatroom;

public class CommonMember extends Member {

	public CommonMember(String name) {
		super(name);
	}

	// 调停者体现在这里
	@Override
	public void sendText(String to, String message) {
		super.chatroom.sendText(getName(), to, message);
	}

	@Override
	public void sendImage(String to, String image) {
		super.chatroom.sendImage(getName(), to, image);
	}

}