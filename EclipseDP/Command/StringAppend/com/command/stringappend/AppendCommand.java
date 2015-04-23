package com.command.stringappend;

public class AppendCommand extends AbstractCommand {

	public AppendCommand(Receiver receiver) {
		super(receiver);
	}

	@Override
	public String Execute(String origin, String addtion) {
		return receiver.append(origin, addtion);
	}

}
