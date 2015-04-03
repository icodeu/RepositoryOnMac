package com.factorymethod.logger;

public class DatabaseLogger implements Logger {

	@Override
	public void wirteLog() {
		System.out.println("DatabaseLogger is Writting Log~~~");
	}

}
