package com.bridge.videoplayer;

public class WindowsOS extends OSVersionAbstract {

	public WindowsOS(VideoFileImplementor implementor) {
		super(implementor);
	}

	@Override
	public void play(String fileName) {
		super.implementor.decode("Windows", fileName);
	}

}
