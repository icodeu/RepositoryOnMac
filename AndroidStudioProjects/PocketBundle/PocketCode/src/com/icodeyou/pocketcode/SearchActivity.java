package com.icodeyou.pocketcode;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import com.icodeyou.pocketcode.adapter.LessonAdapter;
import com.icodeyou.pocketcode.model.Lesson;
import com.icodeyou.pocketcode.utils.HttpUtils;

public class SearchActivity extends Activity {
	
	private EditText search_course_name;
	private TextView search_cancel;
	
	private ListView listView;
	private LessonAdapter adapter;
	private List<Lesson> lessonList;
	
	private Handler getSearchHandler = new Handler() {
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
					String addUserUrl = MainActivity.WEB_PATH + "addUserCount.php?lesson_id=" + lesson.getLesson_id();
					HttpUtils addUserCountUtils = new HttpUtils(addUserUrl, null);
					addUserCountUtils.onlyAccessNetwork();
					Intent intent = new Intent(SearchActivity.this, CourseActivity.class);
					intent.putExtra("lesson_id", lesson.getLesson_id());
					startActivity(intent);
				}
			});
			adapter.notifyDataSetChanged();
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_search);
		
		search_course_name = (EditText) findViewById(R.id.search_course_name);
		
		listView = (ListView) this.findViewById(R.id.listview);
		
		search_cancel = (TextView) findViewById(R.id.search_cancel);
		search_cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		lessonList = new ArrayList<Lesson>();
		adapter = new LessonAdapter(this, lessonList);
		
		search_course_name.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}
			@Override
			public void afterTextChanged(Editable s) {
				HttpUtils getSearchHttpUtils = null;
				try {
					getSearchHttpUtils = new HttpUtils(
							MainActivity.WEB_PATH+"getSearch.php?lesson_name=" + URLEncoder.encode(s.toString(), "UTF-8")    , 
							getSearchHandler);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				getSearchHttpUtils.getJsonString();
			}
		});
	}
}
