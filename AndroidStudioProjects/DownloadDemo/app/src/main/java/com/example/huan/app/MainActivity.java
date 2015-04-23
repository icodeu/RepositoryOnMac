package com.example.huan.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.huan.db.ThreadDAO;
import com.example.huan.db.ThreadDAOImpl;
import com.example.huan.entity.FileInfo;
import com.example.huan.entity.ThreadInfo;
import com.example.huan.service.DownloadService;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    private TextView mTvFileName = null;
    private ProgressBar mPbProgress = null;
    private Button mBtStop = null;
    private Button mBtStart = null;

    private ThreadDAO mDao = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvFileName = (TextView) findViewById(R.id.tvFileName);
        mPbProgress = (ProgressBar) findViewById(R.id.pbProgress);
        mBtStart = (Button) findViewById(R.id.btStart);
        mBtStop = (Button) findViewById(R.id.btStop);
        mPbProgress.setMax(100);


        final FileInfo fileInfo = new FileInfo(0, "http://wirrorcdn.jikexueyuan.com/app/android/GeekAcademy_release1.5.0.apk", "jikexueyuan.apk", 0, 0);

        mTvFileName.setText(fileInfo.getFileName());

        mBtStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DownloadService.class);
                intent.setAction(DownloadService.ACTION_START);
                intent.putExtra("fileInfo", fileInfo);
                startService(intent);
            }
        });

        mBtStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DownloadService.class);
                intent.setAction(DownloadService.ACTION_STOP);
                intent.putExtra("fileInfo", fileInfo);
                startService(intent);
            }
        });

        // 读取上次下载进度
        mDao = new ThreadDAOImpl(MainActivity.this);
        List<ThreadInfo> threads = mDao.getThreads(fileInfo.getUrl());
        // 单线程下载时取得第一个的 finished 值
        if(threads.size() != 0){
            int finished = threads.get(0).getFinished() * 100 / threads.get(0).getEnd();
            // 更新进度条
            mPbProgress.setProgress(finished);
        }


        IntentFilter filter = new IntentFilter();
        filter.addAction(DownloadService.ACTION_UPDATE);
        registerReceiver(mReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }

    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (DownloadService.ACTION_UPDATE.equals(intent.getAction())){
                int finished = intent.getIntExtra("finished", 0);
                mPbProgress.setProgress(finished);
            }
        }
    };

}
