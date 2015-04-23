package com.bridge.videoplayer;

public class Main {

	public static final String fileName = "movie";
	
	public static void main(String[] args) {
		
		VideoFileImplementor implementor = null;
		OSVersionAbstract abstractor = null;
		
		implementor = new MPEGFile();
		abstractor = new WindowsOS(implementor);
		abstractor.play(fileName);
		
		implementor = new RMVBFile();
		abstractor = new LinuxOS(implementor);
		abstractor.play(fileName);
		
	}

}
