package com.example.inputandshow;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.example.system.R;

public class ShowActivity extends Activity{
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//ȫ����ʾ����   
	    requestWindowFeature(Window.FEATURE_NO_TITLE);  
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
	    WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    
//	    setContentView(R.layout.activity_show);
	    this.setContentView(new VoiceView(this)); 
	 }    	
}
