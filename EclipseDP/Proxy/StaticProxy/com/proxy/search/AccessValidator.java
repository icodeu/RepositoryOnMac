package com.proxy.search;

public class AccessValidator {
	
	public boolean validate(String userId){
		if ("wanghuan".equals(userId)){
			System.out.println("Validate--> " + userId + " is valid");
			return true;
		}
		else{
			System.out.println("Validate--> " + userId + " is invalid");
			return false;
		}
	}

}
