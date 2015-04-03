package com.factorymethod.switchdb;

public class OracleFactory implements IDatabaseFactory {

	@Override
	public IDataBase createDatabase() {
		return new Oracle();
	}

}
