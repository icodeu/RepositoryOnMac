package com.factorymethod.switchdb;

public class Main {
	
	public static void main(String[] args) {
		IDatabaseFactory factory = null;
		IDataBase dataBase;
		
		factory = new SQLServerFactory();
		dataBase = factory.createDatabase();
		dataBase.use();
		
		factory = new OracleFactory();
		dataBase = factory.createDatabase();
		dataBase.use();
		
		factory = new AccessFactory();
		dataBase = factory.createDatabase();
		dataBase.use();
	}

}
