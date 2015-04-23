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
	

	private SurfaceHolder mHolder; // 用于控制SurfaceView	 
    private Thread t; // 声明一条线程
    private boolean flag; // 线程运行的标识，用于控制线程
    private Canvas mCanvas; // 声明一张画布
    private Paint p; // 声明一支画笔
    private int x = 300, y = 225, r = 5; // 圆的坐标和半径
    private int voice = 0;
    public VoiceFrequencyCollector collector;
	
    
    public VoiceView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		 mHolder = getHolder(); // 获得SurfaceHolder对象
         mHolder.addCallback(this); // 为SurfaceView添加状态监听
         p = new Paint(); // 创建一个画笔对象
         p.setColor(Color.WHITE); // 设置画笔的颜色为白色
         setFocusable(true); // 设置焦点
         this.init();
	}
   public void init() {
		getHolder().addCallback(this);
		p = new Paint();
		//开始收集频率数据
		collector = new VoiceFrequencyCollector(this);
		collector.setFlag(true);
		collector.start();	
	}
    
    @Override
	public void onDraw(Canvas mCanvas) {
		p.setAntiAlias(true);//抗锯齿
		mCanvas.drawColor(Color.BLACK);//绘制黑背景
		//将voiceCollector的list收集到的所有振动画出。
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
        mCanvas = mHolder.lockCanvas(); // 获得画布对象，开始对画布画画
        mCanvas.drawRGB(0, 0, 0); // 把画布填充为黑色
        mCanvas.drawCircle(x, y, r, p); // 画一个圆
        mHolder.unlockCanvasAndPost(mCanvas); // 完成画画，把画布显示在屏幕上
    }
    /**
     * 当SurfaceView创建的时候，调用此函数
     */
    public void surfaceCreated(SurfaceHolder holder) {
        t = new Thread(this); // 创建一个线程对象
        flag = true; // 把线程运行的标识设置成true
        t.start(); // 启动线程
    }

    /**
     * 当SurfaceView的视图发生改变的时候，调用此函数
     */
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
            int height) {
    }

    /**
     * 当SurfaceView销毁的时候，调用此函数
     */
    public void surfaceDestroyed(SurfaceHolder holder) {
        flag = false; // 把线程运行的标识设置成false
    }

    /**
     * 当屏幕被触摸时调用
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
       if(y>=100&&y<=350){
    	   y = (int) event.getY(); // 获得屏幕被触摸时对应的Y轴坐标
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
            Draw(); // 调用自定义画画方法
            //this.voice = y;
            try {
                Thread.sleep(50); // 让线程休息50毫秒
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}

}