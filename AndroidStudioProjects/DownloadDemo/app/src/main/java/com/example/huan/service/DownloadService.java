package com.example.huan.service;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import com.example.huan.entity.FileInfo;

import org.apache.http.HttpStatus;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadService extends Service {

//    public static final String DOWNLOAD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/download/";
//    public final String DOWNLOAD_PATH = String.valueOf(this.getFilesDir());

    public static final String ACTION_START = "ACTION_START";
    public static final String ACTION_STOP = "ACTION_STOP";
    public static final String ACTION_UPDATE = "ACTION_UPDATE";

    public static final int MSG_INIT = 0;

    private DownloadTask mTask = null;

    public DownloadService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (ACTION_START.equals(intent.getAction())){
            FileInfo fileInfo = (FileInfo) intent.getSerializableExtra("fileInfo");
            Log.i("test", "Start : " + fileInfo.toString());
            // 启动初始化线程
            new InitThread(fileInfo).start();
        }else if (ACTION_STOP.equals(intent.getAction())){
            FileInfo fileInfo = (FileInfo) intent.getSerializableExtra("fileInfo");
            Log.i("test", "Stop :" + fileInfo.toString());
            if (mTask != null){
                mTask.isPause = true;
            }
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case MSG_INIT:
                    FileInfo fileInfo = (FileInfo) msg.obj;
                    Log.i("test", "Init : " + fileInfo);
                    // 启动下载任务
                    mTask = new DownloadTask(DownloadService.this, fileInfo);
                    mTask.download();
                    break;
            }
        }
    };

    class InitThread extends Thread{
        private FileInfo mFileInfo;

        InitThread(FileInfo mFileInfo) {
            this.mFileInfo = mFileInfo;
        }

        @Override
        public void run() {
            HttpURLConnection conn = null;
            RandomAccessFile raf = null;
            try {
                // 连接网络文件
                URL url = new URL(mFileInfo.getUrl());
                conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(3000);
                conn.setRequestMethod("GET");
                int length = -1;
                if (conn.getResponseCode() == HttpStatus.SC_OK){
                    // 获得文件长度
                    length = conn.getContentLength();
                }
                if (length <= 0){
                    return;
                }
                // 在本地创建文件
                File dir = new File(String.valueOf(getFilesDir()));
                if (!dir.exists()){
                    dir.mkdir();
                }
                File file = new File(dir, mFileInfo.getFileName());
                raf = new RandomAccessFile(file, "rwd");
                // 设置文件长度
                raf.setLength(length);
                mFileInfo.setLength(length);
                // 通知线程
                handler.obtainMessage(MSG_INIT, mFileInfo).sendToTarget();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    conn.disconnect();
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
