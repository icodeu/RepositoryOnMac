package com.proxy.search;

public class ProxySearcher implements ISearcher {
	
	private AccessValidator validator = new AccessValidator();
	private Logger logger = new Logger();
	
	private RealSearcher realSearch;

	@Override
	public void doSearch(String userId, String keyWord) {
		if (realSearch == null)
			realSearch = new RealSearcher();
		if (validator.validate(userId)){
			logger.log(userId, keyWord);
			realSearch.doSearch(userId, keyWord);
		}
	}

}
