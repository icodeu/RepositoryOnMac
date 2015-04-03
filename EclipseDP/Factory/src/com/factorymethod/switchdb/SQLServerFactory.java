package com.factorymethod.switchdb;

public class SQLServerFactory implements IDatabaseFactory {

	@Override
	public IDataBase createDatabase() {
		return new SQLServer();
	}

}
