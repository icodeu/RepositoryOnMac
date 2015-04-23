package com.jikexueyuan.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, ServiceConnection {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(MainActivity.this, MyService.class);

        findViewById(R.id.btnStartService).setOnClickListener(this);
        findViewById(R.id.btnStopService).setOnClickListener(this);
        findViewById(R.id.btnBindService).setOnClickListener(this);
        findViewById(R.id.btnUnbindService).setOnClickListener(this);

    }

    private void btnStartService() {
        startService(intent);
    }

    private void btnStopService() {
        stopService(intent);

    }

    private void btnBindService() {
        bindService(intent, this, Service.BIND_AUTO_CREATE);
    }

    private void btnUnbindService() {
        unbindService(this);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("onServiceConnected");
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        System.out.println("onServiceDisconnected");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStartService:
                btnStartService();
                break;
            case R.id.btnStopService:
                btnStopService();
                break;
            case R.id.btnBindService:
                btnBindService();
                break;
            case R.id.btnUnbindService:
                btnUnbindService();
                break;
        }
    }
}
