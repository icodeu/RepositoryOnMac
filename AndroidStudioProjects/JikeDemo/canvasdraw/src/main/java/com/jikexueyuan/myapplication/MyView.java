package com.jikexueyuan.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by huan on 15/4/23.
 */
public class MyView extends View {

    // 固定的X轴
    private static final int X = 400;
    // 每次变化的横向幅度
    private static final int RANGE = 20;
    // 最大所支持点数，超过100则循环使用数组
    private static final int MAX_POINT = 100;
    // 横轴延时时间
    private static final int DELAY_TIME = 1000;

    // 每次触屏时 x y 坐标
    private float curX = 0;
    private float curY = 0;
    // 第一次时开线程
    private boolean isFirst = true;
    // 存储每个点的横纵坐标
    private float[] mPointsX = new float[MAX_POINT];
    private float[] mPointsY = new float[MAX_POINT];
    // 当前点
    private int curIndex = 0;
    // 点的画笔 与 线的画笔
    private Paint pointPaint;
    private Paint linePaint;

    // 子线程中不允许更新UI 需要使用Handler到主线程中更新UI
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            // 通知重绘，调用 onDraw()回调方法
            invalidate();
        }
    };

    public MyView(Context context) {
        super(context);
        pointPaint = new Paint();
        pointPaint.setColor(Color.WHITE);
        pointPaint.setStrokeWidth(10);

        linePaint = new Paint();
        linePaint.setColor(Color.BLUE);
        linePaint.setStrokeWidth(5);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);

        // 遍历数组画点 与 线
        int i = 0;
        for (i=0;i<curIndex;i++){
            mPointsX[i] = mPointsX[i] - RANGE;
            canvas.drawPoint(mPointsX[i], mPointsY[i], pointPaint);
            if (i != 0 ){
                canvas.drawLine(mPointsX[i-1], mPointsY[i-1], mPointsX[i], mPointsY[i], linePaint);
            }
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //第一次则开线程
        if (isFirst){
            doThread();
        }

        // 获取当前触摸坐标
        curX = event.getX();
        curY = event.getY();
        mPointsX[curIndex] = X;
        mPointsY[curIndex] = curY;
        // 取余，以便MAX_POINT个点能够循环使用
        curIndex = (curIndex + 1) % MAX_POINT;

        // 通知窗口重绘
        invalidate();
        return super.onTouchEvent(event);
    }

    private void doThread() {
        isFirst = false;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if (curIndex == 0)
                        continue;
                    mPointsX[curIndex] = mPointsX[curIndex-1] + RANGE;
                    mPointsY[curIndex] = mPointsY[curIndex-1];
                    curIndex = (curIndex + 1) % MAX_POINT;
                    // 通知handler，调用其 handleMessage()方法
                    handler.sendEmptyMessage(0);
                    try {
                        Thread.sleep(DELAY_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
