package com.factorymethod.logger;

public class Main {
	
	public static void main(String[] args) {
		LoggerFactory factory = null;
		Logger logger = null;
		
		factory = new FileLoggerFactory();
		logger = factory.createLogger();
		logger.wirteLog();
		
		factory = new DatabaseLoggerFactory();
		logger = factory.createLogger();
		logger.wirteLog();
	}
	
}
