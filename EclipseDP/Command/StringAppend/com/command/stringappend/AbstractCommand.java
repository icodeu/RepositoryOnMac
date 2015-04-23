package com.command.stringappend;

public abstract class AbstractCommand {
	
	protected Receiver receiver;

	public AbstractCommand(Receiver receiver) {
		this.receiver = receiver;
	}
	
	public abstract String Execute(String origin, String addtion);
	
}
