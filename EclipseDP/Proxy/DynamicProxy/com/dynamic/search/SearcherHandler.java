package com.dynamic.search;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SearcherHandler implements InvocationHandler {

	private Object realObject;
	
	private AccessValidator validator = new AccessValidator();
	private Logger logger = new Logger();
	
	public SearcherHandler(Object realObject) {
		this.realObject = realObject;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// 判定身份 和 记录日志
		String userId = (String) args[0];
		String keyWord = (String) args[1];
		if (validator.validate(userId)){
			logger.log(userId, keyWord);
			// 判定成功并打印日志后执行真正的来自客户端的doSearch()方法
			return method.invoke(realObject, args);
		}
		return null;
	}


}
