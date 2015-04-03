package com.singleton.print;

public class PrintSpooler {

	private static PrintSpooler instance = null;
	private PrintSpooler() {}
	
	public static PrintSpooler getInstance(){
		// 双重检查锁定
		if (instance == null){
			synchronized (PrintSpooler.class) {
				if (instance == null){
					instance = new PrintSpooler();
					return instance;
				}
			}
		}else { // 已有 instance 实例时  抛出异常
			try {
				throw new Exception("Too More Printer!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void delete(){
		System.out.println("删除打印任务");
	}
	public void stop(){
		System.out.println("中止打印任务");
	}
	public void change(){
		System.out.println("改变打印任务");
	}
}
