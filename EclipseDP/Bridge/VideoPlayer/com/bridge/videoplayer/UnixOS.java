package com.bridge.videoplayer;

public class UnixOS extends OSVersionAbstract {

	public UnixOS(VideoFileImplementor implementor) {
		super(implementor);
	}

	@Override
	public void play(String fileName) {
		super.implementor.decode("Linux", fileName);
	}

}
