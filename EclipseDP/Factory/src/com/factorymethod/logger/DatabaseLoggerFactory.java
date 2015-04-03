package com.factorymethod.logger;

public class DatabaseLoggerFactory implements LoggerFactory {

	@Override
	public Logger createLogger() {
		return new DatabaseLogger();
	}

}
