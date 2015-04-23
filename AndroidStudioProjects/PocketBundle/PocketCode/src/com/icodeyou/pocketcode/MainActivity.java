package com.icodeyou.pocketcode;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.icodeyou.pocketcode.adapter.CategoryAdapter;
import com.icodeyou.pocketcode.adapter.LessonAdapter;
import com.icodeyou.pocketcode.model.Category;
import com.icodeyou.pocketcode.model.Lesson;
import com.icodeyou.pocketcode.utils.HttpUtils;
import com.icodeyou.pocketcode.utils.UpdateManager;

public class MainActivity extends Activity implements
		SwipeRefreshLayout.OnRefreshListener {

	private ListView mDrawerList;
	private ArrayList<Category> categoryList;
	private DrawerLayout mDrawerLayout;
	private CategoryAdapter categoryAdapter;

	private SwipeRefreshLayout swipeLayout;
	private ListView listView;
	private LessonAdapter adapter;
	private List<Lesson> lessonList;

	private TextView lesson_title;
	private ImageButton select_lesson;
	private ImageButton search;
	private ImageView is_loading;

	public static final String WEB_PATH = "http://pocketcode.sinaapp.com/";

	private Handler getJsonHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			lessonList.clear();
			String jsonString = (String) msg.obj;
			try {
				JSONArray jsonArray = new JSONArray(jsonString);
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject object = jsonArray.getJSONObject(i);
					lessonList.add(new Lesson(object.getString("lesson_id"),
							object.getString("lesson_name"), object
									.getString("lesson_time"), object
									.getString("user_count"), object
									.getString("lesson_path"), object
									.getString("lesson_desc")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			listView.setAdapter(adapter);
			listView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int position, long arg3) {
					Lesson lesson = lessonList.get(position);
					String addUserUrl = MainActivity.WEB_PATH
							+ "addUserCount.php?lesson_id="
							+ lesson.getLesson_id();
					HttpUtils addUserCountUtils = new HttpUtils(addUserUrl,
							null);
					addUserCountUtils.onlyAccessNetwork();
					Toast.makeText(MainActivity.this, "正在努力加载中 播放时双击画面全屏播放", 0).show();
					Intent intent = new Intent(MainActivity.this,
							CourseActivity.class);
					intent.putExtra("lesson_id", lesson.getLesson_id());
					startActivity(intent);
				}
			});
			is_loading.setVisibility(View.GONE);
			adapter.notifyDataSetChanged();

		}
	};

	private Handler getCategoryHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			categoryList.clear();
			Category category_all = new Category("0", "全部课程");
			category_all.setSelected(true);
			categoryList.add(category_all);
			String jsonString = (String) msg.obj;
			try {
				JSONArray jsonArray = new JSONArray(jsonString);
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject object = jsonArray.getJSONObject(i);
					categoryList.add(new Category(object
							.getString("category_id"), object
							.getString("category_name")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			mDrawerList.setAdapter(categoryAdapter);
			mDrawerList.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int position, long arg3) {
					is_loading.setVisibility(View.VISIBLE);
					Category category = categoryList.get(position);
					HttpUtils getJsonHttpUtils = new HttpUtils(WEB_PATH
							+ "getLesson.php?category_id="
							+ category.getCategory_id(), getJsonHandler);
					getJsonHttpUtils.getJsonString();
					mDrawerLayout.closeDrawers();
					lesson_title.setText(category.getCategory_name());
					// Change indicator on the left
					for (Category someCategory : categoryList) {
						someCategory.setSelected(false);
					}
					category.setSelected(true);
					categoryAdapter.notifyDataSetChanged();
				}
			});
			categoryAdapter.notifyDataSetChanged();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		// 检查新版本
		UpdateManager updateManager = new UpdateManager(this);
		updateManager.checkUpdate();

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		mDrawerList = (ListView) findViewById(R.id.left_menu);

		lesson_title = (TextView) findViewById(R.id.lesson_title);

		listView = (ListView) this.findViewById(R.id.listview);
		swipeLayout = (SwipeRefreshLayout) this
				.findViewById(R.id.swipe_refresh);
		swipeLayout.setOnRefreshListener(this);

		swipeLayout.setColorScheme(android.R.color.holo_red_light,
				android.R.color.holo_green_light,
				android.R.color.holo_blue_bright,
				android.R.color.holo_orange_light);

		lessonList = new ArrayList<Lesson>();
		adapter = new LessonAdapter(this, lessonList);
		categoryList = new ArrayList<Category>();
		categoryAdapter = new CategoryAdapter(this, categoryList);

		HttpUtils getJsonHttpUtils = new HttpUtils(WEB_PATH + "getLesson.php",
				getJsonHandler);
		getJsonHttpUtils.getJsonString();

		HttpUtils getCategoryHttpUtils = new HttpUtils(WEB_PATH
				+ "getCategory.php", getCategoryHandler);
		getCategoryHttpUtils.getJsonString();

		select_lesson = (ImageButton) findViewById(R.id.select_lesson);
		select_lesson.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mDrawerLayout.openDrawer(Gravity.LEFT);
			}
		});
		search = (ImageButton) findViewById(R.id.search);
		search.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						SearchActivity.class);
				startActivity(intent);
			}
		});
		
		is_loading = (ImageView) findViewById(R.id.isLoading);
	}

	@Override
	public void onRefresh() {
//		is_loading.setVisibility(View.VISIBLE);
		lesson_title.setText("全部课程");
		new Handler().postDelayed(new Runnable() {
			public void run() {
				swipeLayout.setRefreshing(false);
				HttpUtils getJsonHttpUtils = new HttpUtils(WEB_PATH
						+ "getLesson.php", getJsonHandler);
				getJsonHttpUtils.getJsonString();

				HttpUtils getCategoryHttpUtils = new HttpUtils(WEB_PATH
						+ "getCategory.php", getCategoryHandler);
				getCategoryHttpUtils.getJsonString();

				adapter.notifyDataSetChanged();
				categoryAdapter.notifyDataSetChanged();
			}
		}, 500);
	}

	private long exitTime = 0;
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			if ((System.currentTimeMillis() - exitTime) > 2000) {
				Toast.makeText(getApplicationContext(), "再按一次退出程序",
						Toast.LENGTH_SHORT).show();
				exitTime = System.currentTimeMillis();
			} else {
				finish();
				System.exit(0);
			}
			return true;
		}
		if (keyCode == KeyEvent.KEYCODE_MENU){
			mDrawerLayout.openDrawer(Gravity.LEFT);
		}
		return super.onKeyDown(keyCode, event);
	}
}
