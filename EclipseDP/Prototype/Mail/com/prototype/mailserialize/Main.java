package com.prototype.mailserialize;

public class Main {

	public static void main(String[] args) {

		Mail mail1 = new Mail();
		mail1.setSender("sender@bjtu.edu.cn");
		mail1.setReceiver("recv@bjtu.edu.cn");
		mail1.setTitle("Hello");
		mail1.setContent("Hello World");
		mail1.setDate("2015-04-02");
		mail1.setAttachment("Attch1");

		// 对象序列化方式克隆
		Mail mail2 = null;
		try {
			mail2 = mail1.deepClone();
			mail2.setAttachment("Attch2");
		} catch (Exception e) {
			e.printStackTrace();
		}

		mail1.show();
		mail2.show();

	}

}
