package com.factorymethod.switchdb;

import com.factorymethod.switchdb.IDataBase;

public class Oracle implements IDataBase {

	@Override
	public void use() {
		System.out.println("Oracle is Using");
	}
	
	

}
