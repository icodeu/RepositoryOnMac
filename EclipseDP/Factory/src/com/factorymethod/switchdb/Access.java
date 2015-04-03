package com.factorymethod.switchdb;

import com.factorymethod.switchdb.IDataBase;

public class Access implements IDataBase {

	@Override
	public void use() {
		System.out.println("Access is Using");
	}
	
	

}
