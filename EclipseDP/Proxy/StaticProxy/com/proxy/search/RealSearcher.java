package com.proxy.search;

public class RealSearcher implements ISearcher {

	@Override
	public void doSearch(String userId, String keyWord) {
		System.out.println(userId + " is search " + keyWord);
	}

}
