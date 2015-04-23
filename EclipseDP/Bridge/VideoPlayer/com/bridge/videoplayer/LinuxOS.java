package com.bridge.videoplayer;

public class LinuxOS extends OSVersionAbstract {

	public LinuxOS(VideoFileImplementor implementor) {
		super(implementor);
	}

	@Override
	public void play(String fileName) {
		super.implementor.decode("Linux", fileName);
	}

}
