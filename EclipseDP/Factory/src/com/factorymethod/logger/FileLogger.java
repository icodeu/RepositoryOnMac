package com.factorymethod.logger;

public class FileLogger implements Logger {

	@Override
	public void wirteLog() {
		System.out.println("FileLogger is Writting Log~~~");
	}

}
