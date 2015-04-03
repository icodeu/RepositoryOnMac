package com.abstractfactory.db;

public class OracleStatement implements IStatement {

	@Override
	public void execute() {
		System.out.println("Oracle Execute Someting");
	}

}
