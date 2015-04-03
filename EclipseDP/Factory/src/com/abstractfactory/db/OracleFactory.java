package com.abstractfactory.db;

public class OracleFactory implements IDBFactory {

	@Override
	public IConnection createConnection() {
		return new OracleConnection();
	}

	@Override
	public IStatement createStatement() {
		return new OracleStatement();
	}

}
