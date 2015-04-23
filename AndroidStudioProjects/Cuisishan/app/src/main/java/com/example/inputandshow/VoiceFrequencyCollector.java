package com.example.inputandshow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.util.Constant;

public class VoiceFrequencyCollector extends Thread {
	/**
	 * 该类是数据的收集者，每隔若干时间会向振动源请求一条记录，并添加到list中。同时将list中所有直线的横坐标x减小，即呈现左移的效果。
	 * 当横坐标减小到0以下，即移出了屏幕左端，则在list中将其移出，实际中应当保留以作数据分析处理。
	 */
	VoiceView view;
	private int sleepSpan = 100;//睡眠的毫秒数
	private int step = 5;
	private boolean flag = true;//循环标记位
	
	public List <VoiceFrequency> list = null;
	
	public VoiceFrequencyCollector(VoiceView view){
		this.view = view;
		list = new ArrayList<VoiceFrequency>();
	}
	public void addVoiceFrequency(VoiceFrequency frequency){
		list.add(frequency);
	}

	@Override
	public void run() {
		while(flag) {
			Iterator<VoiceFrequency> it = list.iterator();
			while(it.hasNext()) {
				VoiceFrequency vf = it.next();
				vf.setX(vf.getX()-step);//将list中所有直线的横坐标x减小，即呈现左移的效果。
				if(vf.getX()<0) {//当横坐标减小到0以下，即移出了屏幕左端，则在list中将其移出，实际中应当保留以作数据分析处理。
					it.remove();
				}
			}
			list.add(new VoiceFrequency((int)Constant.WIDTH,view.getVoice()));

					try{
						Thread.sleep(sleepSpan);//睡眠sleepSpan毫秒
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
			
			
		    public void setFlag(boolean flag) {//设置循环标记
		    	this.flag = flag;
		    }	
}

