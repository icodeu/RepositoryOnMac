package com.factorymethod.switchdb;

public class AccessFactory implements IDatabaseFactory {

	@Override
	public IDataBase createDatabase() {
		return new Access();
	}

}
