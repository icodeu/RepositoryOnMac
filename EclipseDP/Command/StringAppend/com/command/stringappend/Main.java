package com.command.stringappend;

public class Main {

	public static void main(String[] args) {
		
		Receiver receiver = new Receiver();
		AbstractCommand appendCommand = new AppendCommand(receiver);
		AbstractCommand undoCommond = new UndoCommand(receiver);
		Invoker invoker = new Invoker();
		// 设置append命令并执行
		invoker.setCommand(appendCommand);
		String str = invoker.executeCommand("hello", "world");
		System.out.println(str);
		// 设置undo命令并执行
		invoker.setCommand(undoCommond);
		str = invoker.executeCommand(str, null);
		System.out.println(str);

	}
}

// Invoker 里面有个 Command， Command 里面有个 Receiver， Command里面的Execute方法执行Receiver中的Action()