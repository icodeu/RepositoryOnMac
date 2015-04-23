package com.facade.encrypt;

public class Main {

	public static void main(String[] args) {
		
		EncryptFacade facade = new EncryptFacade();
		facade.fileEncrypt("src.txt", "des.txt");
	}

}

// 对客户端隐藏细节  让客户端知道有这么个功能的方法去调用就足够了
