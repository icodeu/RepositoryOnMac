package com.prototype.enlist;

public class Nation implements Cloneable{
	
	private String nation;
	
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	public String getNation() {
		return nation;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
