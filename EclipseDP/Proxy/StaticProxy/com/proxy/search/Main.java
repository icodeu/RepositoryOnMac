package com.proxy.search;

public class Main {

	public static void main(String[] args) {
		
		String userId = "wanghuan";
		String keyWord = "something";
		
		ProxySearcher proxy = new ProxySearcher();
		proxy.doSearch(userId, keyWord);
		
	}

}
