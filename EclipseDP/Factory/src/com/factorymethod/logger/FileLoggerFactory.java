package com.factorymethod.logger;

public class FileLoggerFactory implements LoggerFactory{

	@Override
	public Logger createLogger() {
		return new FileLogger();
	}

}
