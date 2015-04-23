package com.example.inputandshow;


import java.util.Iterator;

import com.example.inputandshow.VoiceFrequency;
import com.example.util.Constant;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class VoiceView extends SurfaceView implements Runnable,Callback{
	

	private SurfaceHolder mHolder; // ���ڿ���SurfaceView	 
    private Thread t; // ����һ���߳�
    private boolean flag; // �߳����еı�ʶ�����ڿ����߳�
    private Canvas mCanvas; // ����һ�Ż���
    private Paint p; // ����һ֧����
    private int x = 300, y = 225, r = 5; // Բ������Ͱ뾶
    private int voice = 0;
    public VoiceFrequencyCollector collector;
	
    
    public VoiceView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		 mHolder = getHolder(); // ���SurfaceHolder����
         mHolder.addCallback(this); // ΪSurfaceView���״̬����
         p = new Paint(); // ����һ�����ʶ���
         p.setColor(Color.WHITE); // ���û��ʵ���ɫΪ��ɫ
         setFocusable(true); // ���ý���
         this.init();
	}
   public void init() {
		getHolder().addCallback(this);
		p = new Paint();
		//��ʼ�ռ�Ƶ������
		collector = new VoiceFrequencyCollector(this);
		collector.setFlag(true);
		collector.start();	
	}
    
    @Override
	public void onDraw(Canvas mCanvas) {
		p.setAntiAlias(true);//�����
		mCanvas.drawColor(Color.BLACK);//���ƺڱ���
		//��voiceCollector��list�ռ����������񶯻�����
		Iterator<VoiceFrequency> it = collector.list.iterator();
		while(it.hasNext()) {
			VoiceFrequency vf = it.next();
			drawVoiceFrequency(mCanvas, p, vf);
		}
	}
	
	public void drawVoiceFrequency(Canvas mCanvas, Paint p, VoiceFrequency vf) {
		int startY = (int)vf.getLength();
		int endY =(int)vf.getLength();
		p.setStrokeWidth(3);
		p.setColor(Color.WHITE);
		mCanvas.drawLine(vf.getX(), startY, vf.getX(), endY, p);
	}
	
    public void Draw() {
        mCanvas = mHolder.lockCanvas(); // ��û������󣬿�ʼ�Ի�������
        mCanvas.drawRGB(0, 0, 0); // �ѻ������Ϊ��ɫ
        mCanvas.drawCircle(x, y, r, p); // ��һ��Բ
        mHolder.unlockCanvasAndPost(mCanvas); // ��ɻ������ѻ�����ʾ����Ļ��
    }
    /**
     * ��SurfaceView������ʱ�򣬵��ô˺���
     */
    public void surfaceCreated(SurfaceHolder holder) {
        t = new Thread(this); // ����һ���̶߳���
        flag = true; // ���߳����еı�ʶ���ó�true
        t.start(); // �����߳�
    }

    /**
     * ��SurfaceView����ͼ�����ı��ʱ�򣬵��ô˺���
     */
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
            int height) {
    }

    /**
     * ��SurfaceView���ٵ�ʱ�򣬵��ô˺���
     */
    public void surfaceDestroyed(SurfaceHolder holder) {
        flag = false; // ���߳����еı�ʶ���ó�false
    }

    /**
     * ����Ļ������ʱ����
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
       if(y>=100&&y<=350){
    	   y = (int) event.getY(); // �����Ļ������ʱ��Ӧ��Y������
       }
       if(y<100){
    	   y=100;
       }
       if(y>350){
    	   y=350;
       }
       onDraw(mCanvas);
        return true;
    }
    public int getVoice() {
		return this.voice;
	}
		
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (flag) {
            Draw(); // �����Զ��廭������
            //this.voice = y;
            try {
                Thread.sleep(50); // ���߳���Ϣ50����
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}

}