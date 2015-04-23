package com.example.inputandshow;

public class VoiceFrequency {
	/**
	 * 该类代表一个声音频率值，在屏幕上具有长度和横坐标两个属性。
	 */
	
	private  int length;//可表示频率
	private  int x;//随时间变化，具体为由屏幕宽度随时间减至0，即从屏幕最右端向左移动直至移出屏幕
	
	public VoiceFrequency(int x, int length) {
		this.x = x;
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
}
