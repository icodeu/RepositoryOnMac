package com.mediator.chatroom;

public interface AbstractChatroom {
	
	public void register(Member member);
	
	public void sendText(String from, String to, String message);
	
	public void sendImage(String from, String to, String image);

}
