package com.abstractfactory.db;

public class MySQLStatement implements IStatement {

	@Override
	public void execute() {
		System.out.println("MySQL Execute Someting");
	}

}
