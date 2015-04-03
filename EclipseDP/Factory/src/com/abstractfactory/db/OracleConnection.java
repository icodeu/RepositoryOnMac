package com.abstractfactory.db;

public class OracleConnection implements IConnection {

	@Override
	public void connect() {
		System.out.println("Oracel Connect");
	}

}
