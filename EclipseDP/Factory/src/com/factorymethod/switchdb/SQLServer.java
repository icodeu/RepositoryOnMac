package com.factorymethod.switchdb;

import com.factorymethod.switchdb.IDataBase;

public class SQLServer implements IDataBase {

	@Override
	public void use() {
		System.out.println("SQLServer is Using");
	}
	
	

}
