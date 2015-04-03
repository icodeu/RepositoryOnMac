package com.abstractfactory.db;

public class Main {

	public static void main(String[] args) {
		IDBFactory factory = null;
		IConnection connection = null;
		IStatement statement = null;
		
		// Use Oracle DB
		factory = new OracleFactory();
		connection = factory.createConnection();
		statement = factory.createStatement();
		
		connection.connect();
		statement.execute();
		
		
		
		// Use MySQL DB
		factory = new MySQLFactory();   //只需要改动这一处
		connection = factory.createConnection();
		statement = factory.createStatement();
		
		connection.connect();
		statement.execute();
	}

}
