package com.prototype.mailserialize;

import java.io.Serializable;

public class Attachment implements Serializable{
	
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
