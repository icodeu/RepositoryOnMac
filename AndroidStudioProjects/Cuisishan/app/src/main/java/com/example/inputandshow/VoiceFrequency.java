package com.example.inputandshow;

public class VoiceFrequency {
	/**
	 * �������һ������Ƶ��ֵ������Ļ�Ͼ��г��Ⱥͺ������������ԡ�
	 */
	
	private  int length;//�ɱ�ʾƵ��
	private  int x;//��ʱ��仯������Ϊ����Ļ�����ʱ�����0��������Ļ���Ҷ������ƶ�ֱ���Ƴ���Ļ
	
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
