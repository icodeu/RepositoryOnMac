package com.abstractfactory.db;

public interface IDBFactory {
	
	public IConnection createConnection();
	public IStatement createStatement();

}
