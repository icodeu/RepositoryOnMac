package com.bridge.videoplayer;

public abstract class OSVersionAbstract {
	
	VideoFileImplementor implementor;
	
	public OSVersionAbstract(VideoFileImplementor implementor) {
		this.implementor = implementor;
	}
	
	public void setImplementor(VideoFileImplementor implementor) {
		this.implementor = implementor;
	}
	
	public abstract void play(String fileName);
	
	

}
