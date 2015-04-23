package com.command.stringappend;

public class UndoCommand extends AbstractCommand {

	public UndoCommand(Receiver receiver) {
		super(receiver);
	}

	@Override
	public String Execute(String origin, String addtion) {
		return receiver.undo(origin);
	}

}
