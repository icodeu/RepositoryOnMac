package com.abstractfactory.db;

public class MySQLConnection implements IConnection {

	@Override
	public void connect() {
		System.out.println("MySQL Connect");
	}

}
