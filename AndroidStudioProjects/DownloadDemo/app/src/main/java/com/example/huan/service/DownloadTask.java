package com.example.huan.service;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.huan.db.ThreadDAO;
import com.example.huan.db.ThreadDAOImpl;
import com.example.huan.entity.FileInfo;
import com.example.huan.entity.ThreadInfo;

import org.apache.http.HttpStatus;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * 下载任务类
 */
public class DownloadTask {

    private Context mContext = null;
    private FileInfo mFileInfo = null;
    private ThreadDAO mDao = null;
    private int mFinished = 0;
    public boolean isPause = false;

    public DownloadTask(Context mContext, FileInfo mFileInfo) {
        this.mContext = mContext;
        this.mFileInfo = mFileInfo;
        mDao = new ThreadDAOImpl(mContext);
    }

    public void download(){
        // 读取数据库的线程信息
        List<ThreadInfo> threadInfos = mDao.getThreads(mFileInfo.getUrl());
        ThreadInfo threadInfo = null;
        if (threadInfos.size() == 0){
            threadInfo = new ThreadInfo(0, mFileInfo.getUrl(), 0, mFileInfo.getLength(), 0);
        }else {
            threadInfo = threadInfos.get(0);
        }
        new DownloadThread(mContext, threadInfo).start();
    }

    /*
    下载线程
     */
    class DownloadThread extends Thread{
        private Context mContext;
        private ThreadInfo mThreadInfo;

        DownloadThread(Context mContext, ThreadInfo mThreadInfo) {
            this.mContext = mContext;
            this.mThreadInfo = mThreadInfo;
        }

        @Override
        public void run() {
            // 向数据库插入线程信息
            if (!mDao.isExists(mThreadInfo.getUrl(), mThreadInfo.getId())){
                mDao.insertThread(mThreadInfo);
                Log.i("test", "threadurl : " + mThreadInfo.getUrl());
            }
            HttpURLConnection conn = null;
            RandomAccessFile raf = null;
            InputStream is = null;
            try{
                URL url = new URL(mThreadInfo.getUrl());
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(3000);
                conn.setRequestMethod("GET");
                // 设置下载位置
                int start = mThreadInfo.getStart() + mThreadInfo.getFinished();
                conn.setRequestProperty("Range", "bytes=" + start + "-" + mThreadInfo.getEnd());
                // 设置文件写入位置
                File file = new File(mContext.getFilesDir(), mFileInfo.getFileName());
                raf = new RandomAccessFile(file, "rwd");
                raf.seek(start);
                Intent intent = new Intent(DownloadService.ACTION_UPDATE);
                mFinished += mThreadInfo.getFinished();
                // 开始下载
                if(conn.getResponseCode() == HttpStatus.SC_PARTIAL_CONTENT){
                    // 读取数据
                    is = conn.getInputStream();
                    byte[] buffer = new byte[1024 * 4];
                    int len = -1;
                    long time = System.currentTimeMillis();
                    while ((len = is.read(buffer)) != -1){
                        // 写入文件
                        raf.write(buffer, 0, len);
                        // 下载进度广播给UI Activity
                        mFinished += len;
                        if (System.currentTimeMillis() - time > 500){
                            time = System.currentTimeMillis();
                            intent.putExtra("finished", mFinished * 100 / mFileInfo.getLength());
                            mContext.sendBroadcast(intent);
                        }
                        // 下载暂停时，保存下载进度
                        if (isPause){
                            mDao.updateThread(mThreadInfo.getUrl(), mThreadInfo.getId(), mFinished);
                            return;
                        }
                    }
                    // 下载完成，删除线程信息
                    mDao.deleteThread(mThreadInfo.getUrl(), mThreadInfo.getId());
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                try {
                    conn.disconnect();
                    raf.close();
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
