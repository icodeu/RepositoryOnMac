package com.bridge.videoplayer;

public class MPEGFile implements VideoFileImplementor {

	@Override
	public void decode(String osType, String fileName) {
		System.out.println("在 " + osType + " 操作系统中, 以MPEG方式解码 " + fileName + " 文件");
	}

}
