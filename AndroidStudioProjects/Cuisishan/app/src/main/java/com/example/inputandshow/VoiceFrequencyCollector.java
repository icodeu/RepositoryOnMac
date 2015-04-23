package com.example.inputandshow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.util.Constant;

public class VoiceFrequencyCollector extends Thread {
	/**
	 * ���������ݵ��ռ��ߣ�ÿ������ʱ�������Դ����һ����¼������ӵ�list�С�ͬʱ��list������ֱ�ߵĺ�����x��С�����������Ƶ�Ч����
	 * ���������С��0���£����Ƴ�����Ļ��ˣ�����list�н����Ƴ���ʵ����Ӧ�������������ݷ�������
	 */
	VoiceView view;
	private int sleepSpan = 100;//˯�ߵĺ�����
	private int step = 5;
	private boolean flag = true;//ѭ�����λ
	
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
				vf.setX(vf.getX()-step);//��list������ֱ�ߵĺ�����x��С�����������Ƶ�Ч����
				if(vf.getX()<0) {//���������С��0���£����Ƴ�����Ļ��ˣ�����list�н����Ƴ���ʵ����Ӧ�������������ݷ�������
					it.remove();
				}
			}
			list.add(new VoiceFrequency((int)Constant.WIDTH,view.getVoice()));

					try{
						Thread.sleep(sleepSpan);//˯��sleepSpan����
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
			
			
		    public void setFlag(boolean flag) {//����ѭ�����
		    	this.flag = flag;
		    }	
}

