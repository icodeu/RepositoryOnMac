package com.mediator.chatroom;

import java.util.HashMap;
import java.util.Map;

public class Chatgroup implements AbstractChatroom {

	private Map<String, Member> members = new HashMap<String, Member>();	
	
	@Override
	public void register(Member member) {
		members.put(member.getName(), member);
	}

	@Override
	public void sendText(String from, String to, String message) {
		// 过滤不雅字符
		if (message.contains("ri")){
			System.out.println("包含非法字符，不予发送");
		}else{
			System.out.println(from + " 向 " + to + " 发送消息 " + message);
			Member member = members.get(to);
			member.receiveText(from, message);
		}
	}

	@Override
	public void sendImage(String from, String to, String image) {
		if ("common".equals(from)){
			System.out.println("普通会员不允许发图片");
		}else{
			System.out.println(from + " 向 " + to + " 发送图片 " + image);
			Member member = members.get(to);
			member.receiveImage(from, image);
		}
	}

}
