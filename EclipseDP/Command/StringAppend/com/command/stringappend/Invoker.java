package com.command.stringappend;

public class Invoker {
	
	private AbstractCommand command;
	
	public void setCommand(AbstractCommand command) {
		this.command = command;
	}
	
	public String executeCommand(String origin, String addtion){
		return command.Execute(origin, addtion);
	}

}
