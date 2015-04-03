package com.singleton.print;

public class Main {

	public static void main(String[] args) {
		
		PrintSpooler printSpooler = PrintSpooler.getInstance();
		printSpooler.delete();
		printSpooler.stop();
		printSpooler.change();
		
		// 试图创建第二个 PrintSpooler 对象时抛出异常
		PrintSpooler printSpooler1 = PrintSpooler.getInstance();
		
	}

}
