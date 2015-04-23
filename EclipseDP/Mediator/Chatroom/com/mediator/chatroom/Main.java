package com.mediator.chatroom;

public class Main {

	public static void main(String[] args) {

		// 调停者
		Chatgroup chatgroup = new Chatgroup();
		
		// 同事关系
		DiamondMember diamondMember = new DiamondMember("diamond");
		CommonMember commonMember = new CommonMember("common");
		
		// 相互绑定
		chatgroup.register(diamondMember);
		chatgroup.register(commonMember);
		diamondMember.setChatroom(chatgroup);
		commonMember.setChatroom(chatgroup);
		
		// sendText 这样的方法最终都调用的是 绑定的调停者的方法，由调停者来执行具体的方法   调停者相当于中介传达命令（中途也可以增加别的操作）
		diamondMember.sendText("common", "hello common");
		commonMember.sendText("diamond", "hello diamond");
		
		diamondMember.sendImage("common", "someimage");
		
		diamondMember.sendText("common", "hello ri");
		commonMember.sendImage("diamond", "someimage");
		
	}

}
