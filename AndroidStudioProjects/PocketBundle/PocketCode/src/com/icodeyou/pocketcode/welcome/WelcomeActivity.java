package com.icodeyou.pocketcode.welcome;

import java.util.ArrayList;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Window;

import cn.jpush.android.api.JPushInterface;

import com.icodeyou.pocketcode.MainActivity;
import com.icodeyou.pocketcode.R;
import com.icodeyou.pocketcode.utils.UpdateManager;

public class WelcomeActivity extends FragmentActivity {

	private ViewPager viewPager;
	private ArrayList<Fragment> mFragments;
	private static final String WELCOME = "welcome";
	private static final String KEY_FIRST = "key_first";
	

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_welcome);
		
		//初始化极光推送
		JPushInterface.setDebugMode(true);
	    JPushInterface.init(this);
		
		SharedPreferences sp = getSharedPreferences(WELCOME, MODE_PRIVATE);
		if (sp.getBoolean(KEY_FIRST, true)) {
			SharedPreferences.Editor editor = sp.edit();
			editor.putBoolean(KEY_FIRST, false);
			editor.commit();
		} else {
			Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
			startActivity(intent);
			finish();
		}

		viewPager = (ViewPager) findViewById(R.id.viewPager);

		mFragments = new ArrayList<Fragment>();

		FirstFragment firstFragment = new FirstFragment();
		SecondFragment secondFragment = new SecondFragment();
		ThirdFragment thirdFragment = new ThirdFragment();
		mFragments.add(firstFragment);
		mFragments.add(secondFragment);
		mFragments.add(thirdFragment);

		FragmentManager fm = getSupportFragmentManager();

		viewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
			@Override
			public int getCount() {
				return mFragments.size();
			}

			@Override
			public Fragment getItem(int position) {
				return mFragments.get(position);
			}
		});

	}
}
