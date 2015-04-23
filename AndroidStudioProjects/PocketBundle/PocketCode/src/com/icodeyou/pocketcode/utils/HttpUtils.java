package com.icodeyou.pocketcode.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.Handler;
import android.os.Message;

public class HttpUtils {
	
	private Handler handler;
	private String url;
	
	public HttpUtils(String url, Handler handler){
		this.url = url;
		this.handler = handler;
	}
	
	public  void getJsonString(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				HttpURLConnection httpURLConnection;
				InputStream is;
				try {
					httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
					httpURLConnection.setRequestMethod("GET");
					is = httpURLConnection.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(is));
					String result = "";
					String line = "";
					while ( (line = reader.readLine())!=null ){
						result += line;
					}
					Message msg = new Message();
					msg.obj = result;
					handler.sendMessage(msg);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}).start();
	}
	
	public  void onlyAccessNetwork(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				HttpURLConnection httpURLConnection;
				InputStream is;
				try {
					httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
					httpURLConnection.setRequestMethod("GET");
					is = httpURLConnection.getInputStream();
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}).start();
	}
}
