package com.abstractfactory.db;

public class MySQLFactory implements IDBFactory {

	@Override
	public IConnection createConnection() {
		return new MySQLConnection();
	}

	@Override
	public IStatement createStatement() {
		return new MySQLStatement();
	}

}
